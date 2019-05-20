package person.liuxx.learn.code.concurrent.local;

/**
 * @author 刘湘湘
 * @since 2019年2月20日 下午5:57:57
 */
public class LocalDemo
{
    class Aa
    {
        int i;

        void s(int s)
        {
            i = s;
        }
    }

    static int f(int i)
    {
        i = 9;
        return i;
    }

    public static void main(String[] args)
    {
        Aa a = new LocalDemo().new Aa();
        a.i = 4;
        System.out.println(a.i);
        System.out.println(f(a.i));
        System.out.println(a.i);
        a.s(7);
        System.out.println(a.i);
    }
}
