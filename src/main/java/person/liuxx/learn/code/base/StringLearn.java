package person.liuxx.learn.code.base;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月22日 上午10:07:12
 * @since 1.0.0
 */
public class StringLearn
{
    static void jvmOptimization()
    {
        String str1 = "aaabbb";
        String str2 = "aaa" + "bbb";
        String str3 = "bbb";
        String str4 = "aaa" + str3;
        final String str5 = "bbb";
        String str6 = "aaa" + str5;
        System.out.println(str1 == str2);
        System.out.println(str1 == str4);
        System.out.println(str1 == str6);
    }

    static void testEqual()
    {
        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;
        System.out.println(str6 == "ab");
    }

    /**
     * 引用改变
     * 
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月22日 上午10:18:11
     * @since 1.0.0
     */
    static void checkQuoteChange()
    {
        String a = "AAA";
        String b = a;
        System.out.println(a == b);
        b = "bbb";
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        String c = "AAA";
        System.out.println(a == c);
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }

    static void joinTest()
    {
        runTest(100);
        runTest(10000);
        runTest(100000);
    }

    static void runTest(int max)
    {
        long startTime = System.nanoTime();
        String s = "1";
        for (int i = 0; i < max; i++)
        {
            s = s + "1";
        }
        long useTime = (System.nanoTime() - startTime) / 1_000;
        System.out.println("使用+操作字符串拼接" + max + "次，时间：" + useTime + "毫秒");
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++)
        {
            sb.append("1");
        }
        useTime = (System.nanoTime() - startTime) / 1_000;
        System.out.println("使用StringBuilder操作字符串拼接" + max + "次，时间：" + useTime + "毫秒");
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < max; i++)
        {
            sbf.append("1");
        }
        useTime = (System.nanoTime() - startTime) / 1_000;
        System.out.println("使用StringBuffer操作字符串拼接" + max + "次，时间：" + useTime + "毫秒");
        System.out.println("--------");
    }

    public static void main(String[] args)
    {
        jvmOptimization();
    }
}
