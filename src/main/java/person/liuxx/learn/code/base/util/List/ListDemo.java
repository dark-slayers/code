package person.liuxx.learn.code.base.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月28日 下午3:44:05
 * @since 1.0.0
 */
public class ListDemo
{
    private static final String[] array =
    { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

    public void run()
    {
        removeRange();
        removeRange2();
    }

    void removeRange()
    {
        List<String> list = new ArrayList<>(Arrays.asList(array));
        // 遍历删除数组元素时，每删除一个元素，都会导致数组大小改变和被删除元素索引位置之后的元素索引前移
        // 需要从索引较大的值开始删除
        for (int i = list.size(); i > 0; i--)
        {
            if (i >= 1 && i <= 4)
            {
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    void removeRange2()
    {
        List<String> list = new ArrayList<>(Arrays.asList(array));
        for (int i = 2; i <= 5; i++)
        {
            list.remove(2 - 1);
        }
        System.out.println(list);
    }
}
