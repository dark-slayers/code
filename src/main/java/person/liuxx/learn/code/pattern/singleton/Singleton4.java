package person.liuxx.learn.code.pattern.singleton;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月31日 下午1:16:44
 * @since 1.0.0
 */
public class Singleton4
{
    private static final Singleton4 instance;
    private static final boolean hasInstance;
    static
    {
        instance = new Singleton4();
        hasInstance = true;
    }

    private Singleton4()
    {
        if (hasInstance)
        {
            throw new AssertionError("禁止多次调用单例构造器！");
        }
    }

    public static Singleton4 getInstance()
    {
        return instance;
    }
}
