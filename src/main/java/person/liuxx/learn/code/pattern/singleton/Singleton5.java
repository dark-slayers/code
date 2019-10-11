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
    private volatile static boolean hasInstance = false;

    private Singleton5()
    {
        if (hasInstance)
        {
            throw new AssertionError("禁止多次调用构造器！");
        }
    }

    public static Singleton5 getInstance()
    {
        // 如果instance对象未加volatile修饰，则可能出现如下异常：
        // thread1检查instance对象不存在，thread1加锁，并且实例化instance对象。
        // thread2检查instance对象存在，返回instance对象。
        // 由于thread2中不存在可视边界，获取到的instance对象可能为未初始化完成的错误对象。
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
