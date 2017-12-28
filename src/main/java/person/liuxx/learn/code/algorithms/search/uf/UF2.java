package person.liuxx.learn.code.algorithms.search.uf;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月20日 下午4:16:18
 * @since 1.0.0
 */
public class UF2 implements UF
{
    private int[] id;
    private int count;

    public UF2(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    @Override
    public int count()
    {
        return count;
    }

    @Override
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    @Override
    public int find(int p)
    {
        // if (p == id[p])
        // {
        // return p;
        // }
        // p = id[p];
        // return find(p);
        while (p != id[p])
        {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
        {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
}
