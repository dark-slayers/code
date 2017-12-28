package person.liuxx.learn.code.algorithms.sort;

import java.util.Random;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月27日 下午2:53:04
 * @since 1.0.0
 */
public class SortRun
{
    private static SortAlgorithms sortAlgorithms;

    static void f()
    {
        sortAlgorithms = new Insertion();
        int[] a = SortAlgorithms.createArray(100, 30);
        SortAlgorithms.show(a);
        sortAlgorithms.sort(a);
        SortAlgorithms.show(a);
    }

    static void s()
    {
        sortAlgorithms = new Insertion();
        int[] a = SortAlgorithms.createArray(100_100, 1_000_100);
        Random rand = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++)
        {
            int index1 = rand.nextInt(100_100);
            int index2 = rand.nextInt(100_100);
            if (a[index1] > a[index2])
            {
            }
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("比较时间：" + endTime);
        long startTime2 = System.nanoTime();
        for (int i = 0; i < 100000; i++)
        {
            int index1 = rand.nextInt(100_100);
            int index2 = rand.nextInt(100_100);
            SortAlgorithms.exch(a, index1, index2);
        }
        long endTime2 = System.nanoTime() - startTime2;
        System.out.println("交换时间：" + endTime2);
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月27日 下午2:53:04
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        s();
    }
}
