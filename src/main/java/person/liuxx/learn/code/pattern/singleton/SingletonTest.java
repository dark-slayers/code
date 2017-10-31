package person.liuxx.learn.code.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月31日 上午9:12:50
 * @since 1.0.0
 */
public class SingletonTest
{
    public static <T> void testSync(Callable<T> task, Class<T> cl)
    {
        System.out.println("对类进行同步测试:" + cl);
        final int max = 100;
        ExecutorService exec = Executors.newFixedThreadPool(max);
        ExecutorCompletionService<T> service = new ExecutorCompletionService<T>(exec);
        for (int i = 0; i < max; i++)
        {
            service.submit(task);
        }
        List<T> list = new ArrayList<>();
        try
        {
            for (int i = 0; i < max; i++)
            {
                Future<T> f = service.take();
                T s = f.get();
                list.add(s);
            }
        } catch (InterruptedException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        System.out.println("生成对象列表长度：" + list.size());
        T id = list.get(0);
        int count = 0;
        for (int i = 0, l = list.size(); i < l; i++)
        {
            if (list.get(i) != id)
            {
                // System.out.println("非单例对象，index:" + i);
                count++;
            }
        }
        System.out.println("一共存在" + count + "个与列表第一个不相同的对象");
        exec.shutdown();
    }

    @SuppressWarnings("unchecked")
    public static <T> void testRef(T t)
    {
        Class<?> c = t.getClass();
        System.out.println("对类型进行反射测试：" + c);
        T p = null;
        try
        {
            Constructor<T> con = (Constructor<T>) c.getDeclaredConstructor();
            // 得到私有访问权限，如果不设置，则无法实例化对象
            con.setAccessible(true);
            // 实例化对象
            p = con.newInstance();
        } catch (InstantiationException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException
                | NoSuchMethodException
                | SecurityException e)
        {
            // e.printStackTrace();
        }
        if (Objects.isNull(p))
        {
            System.out.println("通过反射创建对象失败！");
        } else
        {
            System.out.println("反射创建对象与静态工厂创建的对象是否为同一个：" + (p == t));
        }
        System.out.println(">>>>>>>>>>>>>>>" + c + "测试结束<<<<<<<<<<<<<<<<<<<<");
    }

    public static void test1()
    {
        testSync(() -> Singleton1.getInstance(), Singleton1.class);
        testRef(Singleton1.getInstance());
    }

    public static void test2()
    {
        testSync(() -> Singleton2.getInstance(), Singleton2.class);
        testRef(Singleton2.getInstance());
    }

    public static void test3()
    {
        testSync(() -> Singleton3.INSTANCE, Singleton3.class);
        testRef(Singleton3.INSTANCE);
    }

    public static void test4()
    {
        testSync(() -> Singleton4.getInstance(), Singleton4.class);
        testRef(Singleton4.getInstance());
    }

    public static void test5()
    {
        testSync(() -> Singleton5.getInstance(), Singleton5.class);
        testRef(Singleton5.getInstance());
    }

    public static void test6()
    {
        testSync(() -> Singleton6.getInstance(), Singleton6.class);
        testRef(Singleton6.getInstance());
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年10月31日 上午9:12:50
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
