package person.liuxx.learn.code.base.reflection;

import java.lang.reflect.Field;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月25日 上午9:19:52
 * @since 1.0.0
 */
public class FinalModifyDemo
{
    public int value()
    {
        return new A().f();
    }

    public void run()
    {
        int i = new A().f();
        System.out.println(i);
    }
}

class A
{
    final int a;

    A()
    {
        a = 1;
    }

    int f()
    {
        return d(this, this);
    }

    int d(A a1, A a2)
    {
        int i = a1.a;
        modify(a1);
        int j = a2.a;
        return j - i;
    }

    static void modify(A a)
    {
        try
        {
            Field f = a.getClass().getDeclaredField("a");
            f.setAccessible(true);
            f.setInt(a, 2);
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        } catch (SecurityException e)
        {
            e.printStackTrace();
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
