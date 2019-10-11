package person.liuxx.learn.code.tool.apache.poi.excel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author 刘湘湘
 * @version 1.3.0<br>
 *          创建时间：2018年10月9日 上午9:27:14
 * @since 1.3.0
 */
public class Temp
{
    static final String path = "E:/项目/标准应用程序运行统计表_08月报_20190801-20190831_用户+应用程序.xlsx";

    /**
     * @author 刘湘湘
     * @version 1.3.0<br>
     *          创建时间：2018年10月9日 上午9:27:14
     * @since 1.3.0
     * @param args
     */
    public static void main(String[] args)
    {
        try (InputStream input = Files.newInputStream(Paths.get(path));
                Workbook workBook = WorkbookFactory.create(input);)
        {
            Sheet sheet = workBook.getSheetAt(0);
            Map<Integer, String> timeKeyMap = new HashMap<>();
            Map<String, Map<String, Long>> map = new HashMap<>();
            for (Row row : sheet)
            {
                if (row.getRowNum() == 0)
                {
                    for (Cell cell : row)
                    {
                        if (cell.getColumnIndex() > 3)
                        {
                            timeKeyMap.put(cell.getColumnIndex(), cell.getStringCellValue());
                        }
                    }
                } else
                {
                    Optional<String> nameOptional = Optional.ofNullable(row)
                            .map(r -> r.getCell(2))
                            .map(c -> c.getStringCellValue());
                    if (!nameOptional.isPresent())
                    {
                        break;
                    }
                    Map<String, Long> tempMap = new HashMap<>();
                    for (Cell cell : row)
                    {
                        if (cell.getColumnIndex() > 3)
                        {
                            String key = timeKeyMap.get(cell.getColumnIndex());
                            long value = changeToSecond(cell);
                            if (value != 0)
                            {
                                tempMap.put(key, value);
                            }
                        }
                        map.put(nameOptional.get(), tempMap);
                    }
                }
            }
            System.out.println(map);
        } catch (EncryptedDocumentException | InvalidFormatException | IOException e)
        {
            e.printStackTrace();
        }
    }

    static int intValue(Row r)
    {
        Optional<Cell> cellOptional = Optional.ofNullable(r).map(row -> row.getCell(0));
        Optional<Integer> cellValue = cellOptional.map(cell ->
        {
            if (Objects.equals(cell.getCellTypeEnum(), CellType.NUMERIC))
            {
                return (int) cell.getNumericCellValue();
            } else
            {
                cell.setCellType(CellType.STRING);
                String text = cell.getStringCellValue();
                return Integer.valueOf(text);
            }
        });
        return cellValue.orElseThrow(() ->
        {
            throw new IllegalArgumentException("aaaaa");
        });
    }

    static long stringToSecond(String time)
    {
        long result = 0;
        int dayIndex = time.indexOf("d");
        if (dayIndex > 0)
        {
            String dayTime = time.substring(0, dayIndex);
            result = result + Integer.valueOf(dayTime) * (24 * 60 * 60);
            if (dayIndex == time.length())
            {
                return result;
            }
            time = time.substring(dayIndex + 1).trim();
        }
        String[] array = time.split(":");
        result = result + Integer.valueOf(array[0]) * 60 * 60 + Integer.valueOf(array[1]) * 60
                + Integer.valueOf(array[2]);
        return result;
    }

    static long dateToSecond(Date date)
    {
        long result = 0;
        Instant zero = Instant.parse("1899-12-30T16:00:00Z");
        Instant instant = date.toInstant();
        result = zero.until(instant, ChronoUnit.SECONDS);
        return result;
    }

    static long changeToSecond(Cell cell)
    {
        long value = 0;
        if (Objects.equals(cell.getCellTypeEnum(), CellType.NUMERIC))
        {
            value = dateToSecond(cell.getDateCellValue());
        } else
        {
            value = stringToSecond(cell.getStringCellValue());
        }
        System.out.println(value);
        return value;
    }
}
