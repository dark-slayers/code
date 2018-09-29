package person.liuxx.learn.code.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.stream.Collectors;

/**
 * @author 刘湘湘
 * @version 1.1.0<br>
 *          创建时间：2018年8月8日 下午5:07:09
 * @since 1.1.0
 */
public class Base64ToImg
{
    public static void main(String[] args)
    {
        try
        {
            String imgStr = Files.lines(Paths.get("E:/dshell/p.txt")).collect(Collectors.joining());
            // Base64解码
            byte[] b = Base64.getDecoder().decode(imgStr);
            for (int i = 0, max = b.length; i < max; i++)
            {
                if (b[i] < 0)
                {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            String imgFilePath = "E:/dshell/test22.png";// 新生成的图片
            try (OutputStream out = new FileOutputStream(imgFilePath);)
            {
                out.write(b);
                out.flush();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
