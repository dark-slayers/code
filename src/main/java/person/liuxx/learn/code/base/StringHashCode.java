package person.liuxx.learn.code.base;

import java.io.File;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月14日 上午10:30:08
 * @since 1.0.0
 */
public class StringHashCode
{
    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月14日 上午10:30:08
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        String a = "SDFKGJ";
        System.out.println(Integer.toHexString(a.hashCode()));
        String s = Pattern.compile("")
                .splitAsStream(Integer.toHexString("SADF".hashCode()))
                .map(String::toUpperCase)
                .collect(Collectors.joining(File.separator));
        System.out.println(s);
    }
}
