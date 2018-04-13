package person.liuxx.learn.code.java7.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月13日 上午8:47:54
 * @since 1.0.0
 */
public class PathDemo
{
    public static void demo()
    {
        baseDemo();
        resolveDemo();
        relativizeDemo();
    }

    static void baseDemo()
    {
        Path path = Paths.get("D:/temp/a.js");
        // D:\temp\a.js
        System.out.println(path);
        Path root = path.getRoot();
        // D:\
        System.out.println(root);
        // D:\temp
        System.out.println(path.getParent());
        // a.js
        System.out.println(path.getFileName());
        // 2
        System.out.println(path.getNameCount());
        // temp
        System.out.println(path.getName(0));
        // a.js
        System.out.println(path.getName(1));
        // sun.nio.fs.WindowsFileSystem@15db9742
        System.out.println(path.getFileSystem());
    }

    static void resolveDemo()
    {
        Path root = Paths.get("D:/temp");
        String sub = "aa/ss";
        Path targetPath = root.resolve(sub);
        // D:\temp\aa\ss
        System.out.println(targetPath);
        sub = "/aa/ss";
        targetPath = root.resolve(sub);
        // D:\aa\ss
        System.out.println(targetPath);
    }

    static void relativizeDemo()
    {
        Path root = Paths.get("D:/temp");
        Path sub = Paths.get("D:/temp/aa/ss");
        Path targetPath = root.relativize(sub);
        // aa\ss
        System.out.println(targetPath);
        targetPath = sub.relativize(root);
        // ..\..
        System.out.println(targetPath);
    }
}
