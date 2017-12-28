package person.liuxx.learn.code.algorithms.test;

import java.util.Arrays;

import person.liuxx.learn.code.algorithms.AlgorithmsData;
import person.liuxx.learn.code.algorithms.search.uf.UF;
import person.liuxx.learn.code.algorithms.search.uf.UF1;
import person.liuxx.learn.code.algorithms.search.uf.UF2;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月22日 上午10:11:58
 * @since 1.0.0
 */
public class AlgorithmsDataTest<T extends AlgorithmsData<T>>
{
    private final static int MAX = 500_000;
    private Object[] sampleData = new Object[MAX];
    private T[] algorithms;

    public AlgorithmsDataTest(T[] a)
    {
        initData(a);
    }

    /**
     * 初始化数据
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月22日 上午10:15:12
     * @since 1.0.0
     */
    private void initData(T[] a)
    {
        algorithms = a;
        for (int i = 0; i < MAX; i++)
        {
            sampleData[i] = algorithms[0].sampleData();
        }
        System.out.println("数据初始化完成！");
    }

    /**
     * 对比测试
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月22日 上午10:15:16
     * @since 1.0.0
     */
    public void contrastTest()
    {
        for (T task : algorithms)
        {
            double[] d = complexityTest(task, 10);
            System.out.println(Arrays.toString(d));
        }
    }

    public void contrastTest(int n)
    {
        for (T task : algorithms)
        {
            double d = timeTrial(n, task);
            System.out.println(d);
        }
    }

    /**
     * 复杂度测试
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月22日 上午10:15:09
     * @since 1.0.0
     */
    public double[] complexityTest(T task, int n)
    {
        int N = 25;
        double prev = timeTrial(N, task);
        double[] result = new double[n];
        N = N + N;
        for (int i = 0; i < n; i++)
        {
            double t = timeTrial(N, task);
            result[i] = t / prev;
            prev = t;
            N = N + N;
        }
        return result;
    }

    private double timeTrial(int N, T task)
    {
        long start = System.nanoTime();
        int index = 0;
        for (Object o : sampleData)
        {
            if (index == N)
            {
                break;
            }
            task.run(o);
            index++;
        }
        long time = System.nanoTime() - start;
        return time / (1000.0);
    }

    public static void main(String[] args)
    {
        AlgorithmsDataTest<UF> a = new AlgorithmsDataTest<UF>(new UF[]
        { new UF2(UF.MAX), new UF1(UF.MAX) });
        a.contrastTest(10000);
    }
}
