package person.liuxx.learn.code.algorithms.search.uf;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月3日 下午2:22:13
 * @since 1.0.0
 */
public interface UF
{
    /**
     * 返回连通分量的数量
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月3日 下午2:23:26
     * @since 1.0.0
     * @return 连通分量的数量
     */
    int count();

    /**
     * 检测触点p和触点q是否位于同一个分量
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月3日 下午2:23:23
     * @since 1.0.0
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    /**
     * 返回分量标识符
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月3日 下午2:21:20
     * @since 1.0.0
     * @param p
     * @return
     */
    int find(int p);

    /**
     * 连接触点p和触点q
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年11月3日 下午2:23:20
     * @since 1.0.0
     * @param p
     * @param q
     */
    void union(int p, int q);
}
