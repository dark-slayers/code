package person.liuxx.learn.code.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月28日 上午9:58:53
 * @since 1.0.0
 */
public class FileLearn
{
    static void createFile(String path)
    {
        File file = new File(path);
        try
        {
            file.createNewFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static void createFileNew(String path)
    {
        try
        {
            Files.createFile(Paths.get(path));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月28日 上午9:58:53
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
    }
}
