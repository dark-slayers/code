package person.liuxx.learn.code.base;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年5月25日 上午10:58:17
 * @since 1.0.0
 */
public class BitDemo
{
    public void run()
    {
        int a = 10;
        // a/2 a>>1 = 5
        System.out.print("a>>1 = ");
        System.out.println(a >> 1);
        // a*2 a<<1 = 20
        System.out.print("a<<1 = ");
        System.out.println(a << 1);
        int b = 1500000000;
        int c = 1800000000;
        System.out.println(b + c);
        System.out.println((b + c) / 2);
        System.out.println((b + c) >>> 1);
    }
}
