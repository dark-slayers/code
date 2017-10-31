package person.liuxx.learn.code.pattern.singleton;

import java.util.Objects;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月31日 下午2:28:31
 * @since 1.0.0
 */
public class Singleton5
{
    private volatile static Singleton5 instance;
    private static boolean hasInstance = false;

    private Singleton5()
    {
        if (hasInstance)
        {
            throw new AssertionError("禁止多次调用构造器！");
        }
    }

    public static Singleton5 getInstance()
    {
        if (Objects.isNull(instance))
        {
            synchronized (Singleton5.class)
            {
                if (Objects.isNull(instance))
                {
                    instance = new Singleton5();
                    hasInstance = true;
                }
            }
        }
        return instance;
    }
}
