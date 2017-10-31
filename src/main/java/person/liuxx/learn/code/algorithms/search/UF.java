package person.liuxx.learn.code.algorithms.search;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年10月30日 下午5:10:43
 * @since 1.0.0
 */
public class UF
{
    private int[] id;
    private int count;

    public UF(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    public int find(int p)
    {
        return -1;
    }

    public void union(int p, int q)
    {
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年10月30日 下午5:10:43
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        UF uf = new UF(10);
        int[][] a =
        {
                { 4, 3 },
                { 3, 8 } };
        for (int i = 0, max = a.length; i < max; i++)
        {
            int p = a[i][0];
            int q = a[i][1];
            if (uf.connected(p, q))
            {
                continue;
            }
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + "components");
    }
}
