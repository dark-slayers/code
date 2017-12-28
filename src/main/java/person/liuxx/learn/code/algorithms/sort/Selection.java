package person.liuxx.learn.code.algorithms.sort;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月27日 下午3:08:35
 * @since 1.0.0
 */
public class Selection extends SortAlgorithms
{
    @Override
    public void sort(int[] a)
    {
        for (int i = 0, max = a.length; i < max; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < max; j++)
            {
                if (a[j] < a[minIndex])
                {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
        }
    }
}
