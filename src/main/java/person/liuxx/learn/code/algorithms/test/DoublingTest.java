package person.liuxx.learn.code.algorithms.test;

import java.util.Random;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月30日 下午3:23:34
 * @since 1.0.0
 */
public class DoublingTest
{
    public static double timeTrial(int N)
    {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
        {
            a[i] = rand(MAX);
        }
        long start = System.nanoTime();
        count2(a);
        long time = System.nanoTime() - start;
        return time / (1000.0);
    }

    static int count(int[] a)
    {
        int count = 0;
        int max = a.length;
        for (int x = 0; x < max; x++)
        {
            for (int y = 0; y < max; y++)
            {
                for (int z = 0; z < max; z++)
                {
                    if (x + y + z == 0)
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static int count2(int[] a)
    {
        int count = 0;
        int max = a.length;
        for (int x = 0; x < max; x++)
        {
            for (int y = 0; y < max; y++)
            {
                if (x + y == 0)
                {
                    count++;
                }
            }
        }
        return count;
    }

    static int rand(int max)
    {
        Random rand = new Random();
        int min = -max;
        return min + rand.nextInt(max - min);
    }

    public static void main(String[] args)
    {
        double prev = timeTrial(25);
        for (int N = 50; N < 500000; N = N + N)
        {
            double t = timeTrial(N);
            // System.out.printf("%7d %5.1f\n", N, t);
            System.out.printf("%5.1f\n", t / prev);
            prev = t;
        }
    }
}
