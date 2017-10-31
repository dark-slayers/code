package person.liuxx.learn.code.pattern.singleton;

import java.util.Objects;

import net.jcip.annotations.NotThreadSafe;

/**
 * 非线程安全的单例，只可用于单线程环境
 * 
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月31日 上午9:03:48
 * @since 1.0.0
 */
@NotThreadSafe
public class Singleton1
{
    private static Singleton1 instance;

    private Singleton1()
    {
    }

    public static Singleton1 getInstance()
    {
        if (Objects.isNull(instance))
        {
            instance = new Singleton1();
        }
        return instance;
    }
}
