package person.liuxx.learn.code.io.dir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author 刘湘湘
 * @since 2019年4月14日 上午11:03:46
 */
public class FileWalk
{
    static Path dir = Paths.get(
            "E:/GitProject/tools/src/main/resources/libs/project/javascript/react");

    public static void a(Path p)
    {
        System.out.println("Path:" + p);
        boolean isFile = !Files.isDirectory(p);
        String fileName = dir.relativize(p).toString() + (isFile ? "" : "/");
        System.out.println("fileName:" + fileName);
        if (Objects.equals(fileName, "/"))
        {
            return;
        }
        System.out.println("copy file :" + fileName);
    }

    public static void main(String[] args)
    {
        try
        {
            Files.walk(dir).forEach(f ->
            {
                a(f);
            });
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
