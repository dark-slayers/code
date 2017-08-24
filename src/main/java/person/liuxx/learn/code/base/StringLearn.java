package person.liuxx.learn.code.base;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月22日 上午10:07:12
 * @since 1.0.0
 */
public class StringLearn
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
        String a = "AAA";
        String b = a;
        System.out.println(a == b);
        b = "bbb";
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        String c = "AAA";
        System.out.println(a == c);
    }

    public static void main(String[] args)
    {
        checkQuoteChange();
    }
}
