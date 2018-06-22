package person.liuxx.learn.code.pattern.singleton;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月31日 下午2:35:42
 * @since 1.0.0
 */
public class Singleton6
{
    private static class Holder
    {
        static Singleton6 instance = new Singleton6();
    };

    private static AtomicBoolean hasInstance = new AtomicBoolean(false);

    private Singleton6()
    {
        if (!hasInstance.compareAndSet(false, true))
        {
            throw new AssertionError("禁止多次调用单例构造器！");
        }
    }

    public static Singleton6 getInstance()
    {
        return Holder.instance;
    }
}
