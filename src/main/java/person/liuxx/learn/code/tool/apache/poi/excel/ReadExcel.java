package person.liuxx.learn.code.tool.apache.poi.excel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年2月28日 下午4:36:14
 * @since 1.0.0
 */
public class ReadExcel
{
    static void readExcel()
    {
        Path filePath = Paths.get("");
        final int firstLineIndex = 1;
        try (InputStream input = Files.newInputStream(filePath);
                Workbook workBook = WorkbookFactory.create(input);)
        {
            Sheet sheet = workBook.getSheetAt(0);
            for (Row row : sheet)
            {
                if (row.getRowNum() < firstLineIndex)
                {
                    continue;
                }
            }
        } catch (IOException | EncryptedDocumentException | InvalidFormatException e)
        {
            e.printStackTrace();
        }
    }
}
