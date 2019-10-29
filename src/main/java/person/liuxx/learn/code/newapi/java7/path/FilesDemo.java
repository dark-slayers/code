package person.liuxx.learn.code.newapi.java7.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月29日 上午9:13:22
 * @since 1.0.0
 */
public class FilesDemo
{
    final static Path path = Paths.get("E:/dshell");

    public static void main(String[] args)
    {
        try
        {
            walks();
        } catch (IOException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    static void walks() throws IOException
    {
        Files.walk(path)
                .filter(p -> p.getParent().equals(path))
                .filter(p -> Files.isDirectory(p))
                .forEach(System.out::println);
        Map<Boolean,List<Path>> map=Files.walk(path)
                .filter(p -> p.getParent().equals(path))
                .collect(Collectors.partitioningBy(p->Files.isDirectory(p)));
        System.out.println(map);
    }
}
