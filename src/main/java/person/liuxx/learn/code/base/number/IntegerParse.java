package person.liuxx.learn.code.base.number;

import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月10日 下午3:35:05
 * @since 1.0.0
 */
public class IntegerParse
{
    public static void main(String[] args)
    {
        int i=0xAD;
        System.out.println(i);
        s(4);
    }

    static void s(int i)
    {
        intTo2(i);
        intTo8(i);
        intTo16(i);
    }

    static void intTo2(int i)
    {
        System.out.println(Integer.toBinaryString(i));
    }

    static void intTo8(int i)
    {
        System.out.println(Integer.toOctalString(i));
    }

    static void intTo16(int i)
    {
        System.out.println(Integer.toHexString(i));
    }

    static void f()
    {
        String s = "6a6176612f6c616e672f";
        LinkedList<String> list = Pattern.compile("").splitAsStream(s).collect(Collectors
                .toCollection(LinkedList::new));
        int length = list.size() / 2;
        byte[] array = new byte[length];
        for (int i = 0; i < length; i++)
        {
            String tt = list.pop() + list.pop();
            array[i] = (byte) Integer.parseInt(tt, 16);
        }
        String r = new String(array);
        System.out.println(r);
    }
}
