package person.liuxx.learn.code.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月22日 上午10:10:06
 * @since 1.0.0
 */
public class ListLearn
{
    /**
     * 引用改变
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月22日 上午10:18:11
     * @since 1.0.0
     */
    static void checkQuoteChange()
    {
        List<String> list1 = new ArrayList<>();
        list1.add("AAA");
        String b = list1.get(0);
        System.out.println(list1.get(0) == b);
        b = "bbb";
        System.out.println(list1.get(0));
        System.out.println(b);
        System.out.println(list1.get(0) == b);
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月22日 上午10:10:06
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        checkQuoteChange();
    }
}
