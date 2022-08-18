package person.liuxx.learn.code.io.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 文件对比
 * 
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年4月24日 上午10:09:17
 * 
 * @since 1.0.0
 */
public class FileCompared {
    /**
     * @author
     * 
     * @version 1.0.0<br>
     *          创建时间：2022年4月24日 上午10:09:17
     * 
     * @since 1.0.0
     * 
     * @param args
     */
    public static void main(String[] args) {
        String path1 = "";
        String path2 = "";
        compared1(path1, path2);
        compared2(path1, path2);
    }

    public static boolean compared1(String path1, String path2) {
        long start = System.nanoTime();
        try (InputStream in1 = Files.newInputStream(Paths.get(path1));
                InputStream in2 = Files.newInputStream(Paths.get(path2))) {
            int oldChar = 0;
            int newChar = 0;
            while (true) {
                oldChar = in1.read();
                newChar = in2.read();
                if (oldChar != -1 && newChar != -1) {
                    if (oldChar != newChar) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime() - start;
        System.out.println("方法1使用时间为：" + end);
        return true;
    }

    public static boolean compared2(String path1, String path2) {
        long start = System.nanoTime();
        long end = System.nanoTime() - start;
        System.out.println("方法2使用时间为：" + end);
        return true;
    }
}
