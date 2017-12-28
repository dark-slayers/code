package person.liuxx.learn.code.algorithms.sort;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月27日 下午4:21:07
 * @since 1.0.0
 */
public class Insertion extends SortAlgorithms
{
    @Override
    public void sort(int[] a)
    {
        for (int i = 1, max = a.length; i < max; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (a[j] >= a[j - 1])
                {
                    break;
                }
                exch(a, j, j - 1);
            }
        }
    }
}
