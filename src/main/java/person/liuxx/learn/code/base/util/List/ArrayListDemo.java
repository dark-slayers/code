package person.liuxx.learn.code.base.util.List;

import java.lang.reflect.Field;
import java.util.ArrayList;

import person.liuxx.learn.code.mvc.Demo;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年5月17日 上午9:23:50
 * @since 1.0.0
 */
public class ArrayListDemo implements Demo
{
    public void run()
    {
        showInit();
    }

    /**
     * 使用不同的方式进行空白ArrayList初始化时，会导致初始容量的不同 <br>
     * ArrayList()初始容量为0，添加第一个元素之后容量为10 <br>
     * ArrayList(0)初始容量为0，添加第一个元素之后容量为1
     * <p>
     * 扩容时会进行开销较大的数组复制，ArrayList进行数组扩容时扩大1.5倍<br>
     * 如果进行元素的持续添加，最小容量为10的列表在元素数量未满10个时不进行扩容，超过10个时进行扩容(10->15)<br>
     * 最小容量为1的列表会进行多次扩容（1->2->3->4->6->9->13）
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年5月17日 上午9:26:48
     * @since 1.0.0
     */
    void showInit()
    {
        ArrayList<String> list = new ArrayList<>(0);
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list = new ArrayList<>();
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
        list.add("A");
        showElementDataLength(list);
    }

    /**
     * 显示ArrayList中的Object数组的长度和List有效元素的数量
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年5月17日 上午9:24:51
     * @since 1.0.0
     * @param list
     */
    void showElementDataLength(ArrayList<String> list)
    {
        try
        {
            Field dataField = ArrayList.class.getDeclaredField("elementData");
            dataField.setAccessible(true);
            System.out.format("Size: %2d, Capacity: %2d%n", list.size(), ((Object[]) dataField.get(
                    list)).length);
        } catch (IllegalArgumentException
                | NoSuchFieldException
                | SecurityException
                | IllegalAccessException e1)
        {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
    }
}
