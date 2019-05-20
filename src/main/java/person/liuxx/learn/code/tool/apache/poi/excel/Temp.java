package person.liuxx.learn.code.tool.apache.poi.excel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    /**
     * @author 刘湘湘
     * @version 1.3.0<br>
     *          创建时间：2018年10月9日 上午9:27:14
     * @since 1.3.0
     * @param args
     */
    public static void main(String[] args)
    {
        try (InputStream input = Files.newInputStream(Paths.get("E:/项目/百灵鸟/加工品/Doc/ERROR/副本副本20000193574- 洛峰项目温度计用部品加工依赖——.xlsx"));
                Workbook workBook = WorkbookFactory.create(input);)
        {
            Sheet sheet = workBook.getSheetAt(0);
            Row row=sheet.getRow(12);
            Cell cell=row.getCell(14);
            System.out.println(cell);
        } catch (EncryptedDocumentException | InvalidFormatException | IOException e)
        {
            // TODO 自动生成的 catch 块
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
}
