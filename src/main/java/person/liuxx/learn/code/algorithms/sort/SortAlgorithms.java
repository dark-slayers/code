package person.liuxx.learn.code.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月27日 下午2:51:03
 * @since 1.0.0
 */
public abstract class SortAlgorithms
{
    /** 使用长度和最大值参数，生成一个随机数字组成的int数组
    * @author  刘湘湘 
    * @version 1.0.0<br>创建时间：2017年11月27日 下午3:22:22
    * @since 1.0.0 
    * @param n 数组长度
    * @param max 数组最大值（不包含）
    * @return 随机数组
    */
    public static int[] createArray(int n, int max)
    {
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
        {
            array[i] = rand.nextInt(max);
        }
        return array;
    }

    /** 对参数数组进行排序
    * @author  刘湘湘 
    * @version 1.0.0<br>创建时间：2017年11月27日 下午3:23:36
    * @since 1.0.0 
    * @param a 需要排序的数组
    */
    public abstract void sort(int[] a);

    /** 交换数组中指定的两个位置的值（简化算法，没有对位置信息做边界有效性校验）
    * @author  刘湘湘 
    * @version 1.0.0<br>创建时间：2017年11月27日 下午3:24:04
    * @since 1.0.0 
    * @param a 数组
    * @param index1 位置1
    * @param index2 位置2
    */
    static void exch(int[] a, int index1, int index2)
    {
        int t = a[index1];
        a[index1] = a[index2];
        a[index2] = t;
    }

    /** 
    * @author  刘湘湘 
    * @version 1.0.0<br>创建时间：2017年11月27日 下午4:26:41
    * @since 1.0.0 
    * @param a
    */
    public static void show(int[] a)
    {
        System.out.println(Arrays.toString(a));
        
    }
}
