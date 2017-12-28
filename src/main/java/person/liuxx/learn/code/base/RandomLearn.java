package person.liuxx.learn.code.base;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月23日 上午9:41:32
 * @since 1.0.0
 */
public class RandomLearn
{
    static void nextInt()
    {
        Random rand = new Random();
        int max = 50;
        int[] array = new int[max];
        for (int i = 0; i < max; i++)
        {
            array[i] = rand.nextInt(10);
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月23日 上午9:41:32
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        nextInt();
    }
}
