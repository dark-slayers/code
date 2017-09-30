package person.liuxx.learn.code.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年9月30日 上午9:38:55
 * @since 1.0.0
 */
public class Run
{
    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年9月30日 上午9:38:55
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            String s = Files.lines(Paths.get("E:\\GitHYC\\larkpage\\package.json")).collect(
                    Collectors.joining());
            System.out.println(s);
            System.out.println(s.length());
            System.out.println(s.substring(420, 430));
        } catch (IOException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
