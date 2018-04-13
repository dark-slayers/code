package person.liuxx.learn.code.java8.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import person.liuxx.util.file.FileUtil;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月31日 下午5:11:42
 * @since 1.0.0
 */
public class FileLearn
{
    static Path source = Paths.get("D:/temp/a.js");
    static Path dest = Paths.get("D:/temp/aa/c.js");

    public static void s()
    {
        Path a = Paths.get("D:/temp/");
        try
        {
            Files.walk(a)
                    .filter(p -> Objects.equals(a, p.getParent()))
                    .filter(p -> FileUtil.existsFile(p))
                    .forEach(p -> System.out.println(p));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void f()
    {
        Path a = Paths.get("D:/temp/");
        Path b = Paths.get("E:/temp/aa");
        System.out.println(a.getRoot());
        System.out.println(b.getRoot());
        Path c = Objects.equals(a.getRoot(), b.getRoot()) ? a.relativize(b) : Paths.get("");
        System.out.println(c);
        System.out.println(Objects.equals(c, Paths.get("")));
        System.out.println(a.resolve(c));
        System.out.println(Objects.equals(a.resolve(c), b));
    }

    public static void run()
    {
        try
        {
            System.out.println(source.getFileName());
            System.out.println(source.getName(1));
            System.out.println(source.getNameCount());
            System.out.println(source.getFileSystem());
            // source.toFile().renameTo(dest.toFile());
            // Files.move(Paths.get("D:/temp/aa/"),Paths.get("D:/temp/aac"));
            Files.move(source, Paths.get("D:/temp/ass.js").getFileName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        s();f();
        run();
    }
}
