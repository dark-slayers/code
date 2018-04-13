package person.liuxx.learn.code.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月13日 下午1:51:24
 * @since 1.0.0
 */
public class ZipDemo
{
    public static void demo()
    {
        Path targetDir = Paths.get("E:/dshell/test.zip");
        Path sourceDir = Paths.get("D:/temp");
        try (OutputStream fout = Files.newOutputStream(targetDir);
                ZipOutputStream zout = new ZipOutputStream(fout);)
        {
            Files.walk(sourceDir).forEach(f ->
            {
                createZip(f, zout, sourceDir);
            });
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void createZip(Path p, ZipOutputStream zout, Path sourceDir)
    {
        boolean isFile = !Files.isDirectory(p);
        String fileName = sourceDir.relativize(p).toString() + (isFile ? "" : "/");
        try
        {
            ZipEntry ze = new ZipEntry(fileName);
            zout.putNextEntry(ze);
            if (isFile)
            {
                try (InputStream fis = Files.newInputStream(p);)
                {
                    int j = 0;
                    byte[] buffer = new byte[1024];
                    while ((j = fis.read(buffer)) > 0)
                    {
                        zout.write(buffer, 0, j);
                    }
                }
            }
            zout.closeEntry();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
