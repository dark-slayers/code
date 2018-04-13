package person.liuxx.learn.code.io;

import java.io.ByteArrayOutputStream;
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
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月12日 下午4:38:36
 * @since 1.0.0
 */
public class Zip
{
    static final int TIME = 10000;
    static AtomicBoolean over = new AtomicBoolean(false);

    public static void zipDir()
    {
        // Path targetDir = Paths.get("E:/dshell/test.zip");
        Path sourceDir = Paths.get("D:/temp");
        try
        {
            PipedInputStream in = new PipedInputStream();
            final PipedOutputStream out = new PipedOutputStream(in);
            Thread thread1 = new Thread(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        ByteArrayOutputStream o = new ByteArrayOutputStream();
                        // OutputStream fout = Files.newOutputStream(targetDir);
                        ZipOutputStream zout = new ZipOutputStream(o);
                        Files.walk(Paths.get("D:/temp")).forEach(f ->
                        {
                            createZip(f, zout, sourceDir);
                        });
                        out.write(o.toByteArray());
                        over.set(true);
                        out.close();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        while (!over.get())
                        {
                            ZipInputStream zis = new ZipInputStream(in);
                            ZipEntry ze = null;
                            while ((ze = zis.getNextEntry()) != null)
                            {
                                if (ze.getName().equals("ss.txt"))
                                {
                                    System.out.println("read ss txt !");
                                    Scanner sc = new Scanner(zis);
                                    while (sc.hasNextLine())
                                    {
                                        System.out.println(sc.nextLine());
                                    }
                                    break;
                                }
                            }
                        }
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
            thread1.start();
            thread2.start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void createZip(Path p, ZipOutputStream zout, Path sourceDir)
    {
        boolean isFile = !Files.isDirectory(p);
        String fileName = sourceDir.relativize(p).toString() + (isFile ? "" : "/");
        System.out.println(fileName);
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
