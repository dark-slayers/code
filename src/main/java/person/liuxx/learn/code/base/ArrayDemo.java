package person.liuxx.learn.code.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月25日 上午10:18:11
 * @since 1.0.0
 */
public class ArrayDemo
{
    public void run()
    {
        int max = Integer.MAX_VALUE;
        // java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        List<String> list = new ArrayList<>(max);
        System.out.println(list.size());
        // java.lang.OutOfMemoryError: Java heap space
        String[] a = new String[max - 10000000];
        System.out.println(a.length);
    }
}
