package person.liuxx.learn.code.algorithms.search.uf;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月3日 下午2:25:13
 * @since 1.0.0
 */
public class UF1 implements UF
{
    private int[] id;
    private int count;

    public UF1(int N)
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
        return id[p];
    }

    @Override
    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
        {
            return;
        }
        for (int i = 0; i < id.length; i++)
        {
            if (id[i] == pID)
            {
                id[i] = qID;
                break;
            }
        }
        count--;
    }
}
