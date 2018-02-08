package person.liuxx.learn.code.algorithms.data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import person.liuxx.learn.code.algorithms.data.impl.Bag2;
import person.liuxx.learn.code.algorithms.data.impl.Bag3;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月15日 上午11:03:01
 * @since 1.0.0
 */
@RunWith(Parameterized.class)
public class BagTest
{
    private Bag<String> emptyBag;
    private Bag<String> bag;
    private String text;

    @Parameters
    public static Collection<Object[]> data()
    {
        return Arrays.asList(new Object[][]
        {
                { Bag2.class, "ABC" },
                { Bag3.class, "ABCABCABCABCABCABCABCABCABCABCABCABCABCABCABC" }, });
    }

    public BagTest(Class<? extends Bag<String>> bClass, String text)
    {
        try
        {
            this.emptyBag = bClass.newInstance();
            this.bag = bClass.newInstance();
            this.text = text;
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年1月15日 上午11:03:01
     * @since 1.0.0
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        for (String s : text.split(""))
        {
            bag.add(s);
        }
    }

    @Test
    public void test()
    {
        assertTrue(emptyBag.isEmpty());
        assertFalse(bag.isEmpty());
        assertTrue(emptyBag.size() == 0);
        assertTrue(bag.size() == text.length());
        StringBuilder check = new StringBuilder();
        for (String s : bag)
        {
            if (Objects.nonNull(s))
            {
                check.append(s);
            }
        }
        System.out.println(check);
        assertTrue(Objects.equals(text, check.toString().trim()));
    }

    @Test
    public void testSync()
    {
        int max = 100;
        ExecutorService exec = Executors.newFixedThreadPool(max);
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<Integer>(exec);
        Callable<Integer> task = new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                emptyBag.add("A");
                return emptyBag.size();
            }
        };
        for (int i = 0; i < max; i++)
        {
            service.submit(task);
        }
        List<Integer> list = new ArrayList<>();
        try
        {
            for (int i = 0; i < max; i++)
            {
                Future<Integer> f = service.take();
                Integer s = f.get();
                list.add(s);
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
