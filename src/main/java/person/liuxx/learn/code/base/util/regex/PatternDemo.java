package person.liuxx.learn.code.base.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刘湘湘
 * @version 1.2.2<br>
 *          创建时间：2018年9月25日 上午9:32:56
 * @since 1.2.2
 */
public class PatternDemo
{
    public static void main(String[] args)
    {
        String[] texts =
        { "在 2018-06-29 13:18:44（服务器时区）成批装入任务", "20000193327", "补生产报缺", "20000180403&20000180404",
                "  20000960036", "20000193302  ", "20000193297", "20000193217" };
        for (String text : texts)
        {
            getDepend(text);
        }
    }

    static void getDepend(String text)
    {
        String regex = "\\d{11}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text.trim());
        while (m.find())
        {
            String meta = m.group();
            System.out.println(meta);
        }
    }
}
