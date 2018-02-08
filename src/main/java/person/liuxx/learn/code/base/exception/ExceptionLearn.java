package person.liuxx.learn.code.base.exception;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月12日 下午4:54:44
 * @since 1.0.0
 */
public class ExceptionLearn
{
    static int index = 8;
    static int f(String text)
    {
        try
        {
            int i = Integer.valueOf(text);
            return i;
        } catch (Exception e)
        {
            return 99;
        } finally
        {
            index = 88888;
        }
    }

    public static void main(String[] args)
    {
        String text = "77dd";
        System.out.println("AAA");
        System.out.println(f(text));
        System.out.println(index);
        System.out.println("END");
    }
}
