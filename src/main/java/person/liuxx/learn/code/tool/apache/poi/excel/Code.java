package person.liuxx.learn.code.tool.apache.poi.excel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * @author 刘湘湘
 * @version 1.1.0<br>
 *          创建时间：2018年8月10日 下午4:16:20
 * @since 1.1.0
 */
public class Code
{
    private static final Path OUTPUT_PATH = Paths.get("./output.xlsx");
    private static final Path SRC_PATH = Paths.get("./原始数据/");
    // private static final Path OUTPUT_PATH =
    // Paths.get("E:/项目/EXCEL工具/output.xlsx");
    // private static final Path SRC_PATH = Paths.get("E:/项目/EXCEL工具/原始数据/");

    class Line
    {
        String time;
        String item;
        String type;
        double number;
        double money;
    }

    private static Stream<Line> parseExcel(Path path)
    {
        System.out.println("读取文件：" + path);
        List<Line> result = new ArrayList<>();
        try (InputStream input = Files.newInputStream(path);
                Workbook workBook = WorkbookFactory.create(input);)
        {
            String fileName = path.getFileName().toString();
            int dotIndex = fileName.lastIndexOf('.');
            String time = fileName.substring(0, dotIndex);
            Sheet sheet = workBook.getSheetAt(0);
            Map<Integer, String> map = new HashMap<>();
            for (Row row : sheet)
            {
                if (Objects.equals(0, row.getRowNum()))
                {
                    for (int k = 1, max = row.getLastCellNum(); k < max; k = k + 2)
                    {
                        Cell cell = row.getCell(k);
                        map.put(k, cell.getStringCellValue());
                    }
                } else
                {
                    Cell c = row.getCell(0);
                    if (Objects.isNull(c))
                    {
                        continue;
                    }
                    c.setCellType(CellType.STRING);
                    String item = c.getStringCellValue();
                    if (item.trim().length() < 1)
                    {
                        continue;
                    }
                    for (int k = 1, max = row.getLastCellNum(); k < max; k = k + 2)
                    {
                        Cell cell = row.getCell(k);
                        double number = readCell(cell).orElse((double) 0);
                        Cell cell2 = row.getCell(k + 1);
                        double money = readCell(cell2).orElse((double) 0);
                        if (number != 0 || money != 0)
                        {
                            Line line = new Code().new Line();
                            line.time = time;
                            line.item = item;
                            line.number = number;
                            line.money = money;
                            line.type = map.get(k);
                            result.add(line);
                        }
                    }
                }
            }
        } catch (IOException | EncryptedDocumentException | InvalidFormatException e)
        {
            e.printStackTrace();
        }
        return result.stream();
    }

    private static Optional<Double> readCell(Cell cell)
    {
        Optional<Double> result = Optional.ofNullable(cell).map(c ->
        {
            c.setCellType(CellType.NUMERIC);
            return cell.getNumericCellValue();
        });
        return result;
    }

    private static List<Line> readDir()
    {
        List<Line> result = new ArrayList<>();
        try
        {
            result = Files.walk(SRC_PATH)
                    .filter(f -> f.getFileName().toString().endsWith(".xlsx"))
                    .flatMap(f -> parseExcel(f))
                    .collect(Collectors.toList());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    private static void writeFile(List<Line> list)
    {
        System.out.println("输出合并后的文件");
        try (SXSSFWorkbook wb = new SXSSFWorkbook(1000);
                OutputStream out = Files.newOutputStream(OUTPUT_PATH);)
        {
            Sheet sh = wb.createSheet();
            for (int i = 0, max = list.size(); i < max; i++)
            {
                Row row = sh.createRow(i);
                Line line = list.get(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(line.time);
                cell = row.createCell(1);
                cell.setCellValue(line.item);
                cell = row.createCell(2);
                cell.setCellValue(line.number);
                cell = row.createCell(3);
                cell.setCellValue(line.money);
                cell = row.createCell(4);
                cell.setCellValue(line.type);
            }
            wb.write(out);
            wb.dispose();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static void mergeExcel()
    {
        List<Line> list = readDir();
        list.sort((o1, o2) -> o1.item.compareTo(o2.item));
        writeFile(list);
    }

    public static void main(String[] args)
    {
        mergeExcel();
    }
}
