package person.liuxx.learn.code.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import person.liuxx.learn.code.base.reflection.FinalModifyDemo;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月25日 上午9:42:44
 * @since 1.0.0
 */
public class ThreadPoolDemo
{
    public void run()
    {
        Callable<Integer> task = new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return new FinalModifyDemo().value();
            }
        };
        List<Integer> list = exec(task);
        System.out.println(list);
    }

    public <T> List<T> exec(Callable<T> task)
    {
        System.out.println("启动线程池...");
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
        } catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        } finally
        {
            exec.shutdown();
        }
        System.out.println("生成对象列表长度：" + list.size());
        return list;
    }
}
