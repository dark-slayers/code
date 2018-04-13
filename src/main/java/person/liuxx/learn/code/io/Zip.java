package person.liuxx.learn.code.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月12日 下午4:38:36
 * @since 1.0.0
 */
public class Zip
{
    public static void zipDir()
    {
        Path targetDir = Paths.get("E:/dshell/test.zip");
        Path sourceDir = Paths.get("D:/temp");
        try (OutputStream fout = Files.newOutputStream(targetDir);
                ZipOutputStream zout = new ZipOutputStream(fout);)
        {
            Files.walk(Paths.get("D:/temp")).forEach(f ->
            {
                createZip(f, zout, sourceDir);
            });
            // PipedInputStream in = new PipedInputStream();
            // final PipedOutputStream out = new PipedOutputStream(in);
            // new Thread(new Runnable() {
            // public void run () {
            // try {
            // out.write(zout);
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
            // }
            // }).start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void createZip(Path p, ZipOutputStream zout, Path sourceDir)
    {
        String fileName = sourceDir.relativize(p).toString();
        System.out.println(fileName);
        if (Files.isDirectory(p))
        {
            fileName = fileName + "/";
            ZipEntry ze = new ZipEntry(fileName);
            try
            {
                zout.putNextEntry(ze);
                zout.closeEntry();
            } catch (IOException e)
            {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        } else
        {
            ZipEntry ze = new ZipEntry(fileName);
            try (InputStream fis = Files.newInputStream(p);)
            {
                zout.putNextEntry(ze);
                int j = 0;
                byte[] buffer = new byte[1024];
                while ((j = fis.read(buffer)) > 0)
                {
                    zout.write(buffer, 0, j);
                }
                zout.closeEntry();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
