package person.liuxx.learn.code.newapi.java7.util;

import com.google.common.base.Objects;

/**
 * @author 刘湘湘
 * @version 1.1.1<br>
 *          创建时间：2018年9月7日 下午5:44:25
 * @since 1.1.1
 */
public class ObjectsDemo
{
    static void compNumber()
    {
        int i = 8;
        Integer i2 = new Integer(8);
        boolean b = Objects.equal(i, i2);
        System.out.println(b);
    }

    /**
     * @author 刘湘湘
     * @version 1.1.1<br>
     *          创建时间：2018年9月7日 下午5:44:25
     * @since 1.1.1
     * @param args
     */
    public static void main(String[] args)
    {
        compNumber();
    }
}
