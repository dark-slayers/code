package person.liuxx.learn.code.algorithms.search.uf;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2017年11月3日 下午2:29:30
* @since 1.0.0 
*/
public class UFRun
{
    /** 
    * @author  刘湘湘 
    * @version 1.0.0<br>创建时间：2017年11月3日 下午2:29:30
    * @since 1.0.0 
    * @param args
    */
    public static void main(String[] args)
    {
        UF uf = new UF1(10);
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
