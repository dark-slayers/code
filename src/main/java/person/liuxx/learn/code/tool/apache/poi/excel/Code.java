package person.liuxx.learn.code.tool.apache.poi.excel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author 刘湘湘
 * @version 1.1.0<br>
 *          创建时间：2018年8月10日 下午4:16:20
 * @since 1.1.0
 */
public class Code
{
    static void compareCode()
    {
        Set<String> plmCodeSet = parseExcel(Paths.get("./plm.xlsx"));
        Set<String> erpCodeSet = parseExcel(Paths.get("./erp.xlsx"));
        Set<String> sameSet = plmCodeSet.stream().filter(s -> erpCodeSet.contains(s)).collect(
                Collectors.toSet());
        Set<String> plmRemainCodeSet = plmCodeSet.stream()
                .filter(s -> !sameSet.contains(s))
                .collect(Collectors.toSet());
        Set<String> erpRemainCodeSet = erpCodeSet.stream()
                .filter(s -> !sameSet.contains(s))
                .collect(Collectors.toSet());
        List<String> lines = new ArrayList<>();
        lines.add("ERP与PLM中相同的物料数量：" + sameSet.size());
        lines.add("\n");
        lines.add("除去相同部分，PLM剩余物料数量：" + plmRemainCodeSet.size());
        lines.add("PLM剩余物料：");
        for (String s : plmRemainCodeSet)
        {
            lines.add(s);
        }
        lines.add("\n");
        lines.add("除去相同部分，ERP剩余物料数量：" + erpRemainCodeSet.size());
        lines.add("ERP剩余物料：");
        for (String s : erpRemainCodeSet)
        {
            lines.add(s);
        }
        try
        {
            Files.write(Paths.get("./erp.xlsx"),lines);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static Set<String> parseExcel(Path path)
    {
        Set<String> result = new HashSet<>();
        try (InputStream input = Files.newInputStream(path);
                Workbook workBook = WorkbookFactory.create(input);)
        {
            Sheet sheet = workBook.getSheetAt(0);
            for (Row row : sheet)
            {
                Optional.ofNullable(row)
                        .map(r -> row.getCell(0))
                        .filter(c -> Objects.equals(c.getCellTypeEnum(), CellType.STRING))
                        .map(c -> c.getStringCellValue())
                        .ifPresent(s -> result.add(s));
            }
        } catch (IOException | EncryptedDocumentException | InvalidFormatException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args)
    {
        compareCode();
    }
}
