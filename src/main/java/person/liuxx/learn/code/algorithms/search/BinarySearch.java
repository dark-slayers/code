package person.liuxx.learn.code.algorithms.search;

/**
 * 二分查找
 * 
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月27日 下午3:02:37
 * @since 1.0.0
 */
public class BinarySearch
{
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
            {
                hi = mid - 1;
            } else if (key > a[mid])
            {
                lo = mid + 1;
            } else
            {
                return mid;
            }
        }
        return -1;
    }

    public static int rank1(int key, int[] a)
    {
        for (int lo = 0, hi = a.length - 1; lo <= hi;)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
            {
                hi = mid - 1;
            } else if (key > a[mid])
            {
                lo = mid + 1;
            } else
            {
                return mid;
            }
        }
        return -1;
    }

    public static int rank2(int key, int[] a, int lo, int hi)
    {
        if (key < a[lo] || key > a[hi] || lo > hi)
        {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key == a[mid])
        {
            return mid;
        } else if (key > a[mid])
        {
            return rank2(key, a, mid, hi);
        } else if (key < a[mid])
        {
            return rank2(key, a, lo, mid);
        }
        return -1;
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年10月27日 下午3:02:37
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        int[] a =
        { 1, 3, 4, 5, 7, 8, 10, 11, 14, 18, 20, 22, 27, 36, 47, 58, 68, 79, 80, 99, 123 };
        int index = rank(5, a);
        System.out.println(index);
        System.out.println(rank2(5, a, 0, a.length - 1));
    }
}
