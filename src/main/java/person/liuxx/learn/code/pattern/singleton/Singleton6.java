package person.liuxx.learn.code.pattern.singleton;

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

    private static boolean hasInstance = false;

    private Singleton6()
    {
        if (hasInstance)
        {
            throw new AssertionError("禁止多次调用单例构造器！");
        } else
        {
            hasInstance = true;
        }
    }

    public static Singleton6 getInstance()
    {
        return Holder.instance;
    }
}
