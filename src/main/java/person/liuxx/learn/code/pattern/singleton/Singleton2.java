package person.liuxx.learn.code.pattern.singleton;

import java.util.Objects;

import net.jcip.annotations.ThreadSafe;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月31日 上午10:34:44
 * @since 1.0.0
 */
@ThreadSafe
public class Singleton2
{
    private static Singleton2 instance;
    private static boolean hasInstance = false;

    private Singleton2()
    {
        synchronized (Singleton2.class)
        {
            if (hasInstance)
            {
                throw new AssertionError("禁止多次调用构造器！");
            }
        }
    }

    public synchronized static Singleton2 getInstance()
    {
        if (Objects.isNull(instance))
        {
            instance = new Singleton2();
        }
        hasInstance = true;
        return instance;
    }
}
