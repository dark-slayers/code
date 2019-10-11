package person.liuxx.learn.code.vm.classfile;

import java.util.Queue;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月10日 下午2:38:54
 * @since 1.0.0
 */
public final class QueueUtil
{
    private QueueUtil()
    {
        throw new AssertionError("工具类禁止实例化！");
    }

    public static String intToHexString(int i)
    {
        String text = Integer.toHexString(i);
        int length = text.length();
        if (length < 2)
        {
            return "0" + text;
        }
        if (length < 3)
        {
            return text;
        }
        return Integer.toHexString(i).substring(length - 2);
    }

    public static String hexString(Queue<Integer> queue, int number)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++)
        {
            result.append(intToHexString(queue.poll()));
        }
        return result.toString();
    }

    public static int getInt(Queue<Integer> queue, int number)
    {
        return Integer.parseInt(hexString(queue, number), 16);
    }
}
