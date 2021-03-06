package person.liuxx.learn.code.base.reflection;

import java.lang.reflect.Field;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年8月2日 下午4:44:30
 * @since 1.0.0
 */
public class FinalModifyDemo2
{
    private final String a = null==null?"A":"B";

    void update() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
            IllegalAccessException
    {
        Field field = this.getClass().getDeclaredField("a");
        field.setAccessible(true);
        field.set(this, "Hello");
    }

    void show()
    {
        System.out.println(a);
    }

    public static void main(String[] args)
    {
        FinalModifyDemo2 a = new FinalModifyDemo2();
        try
        {
            a.update();
            a.show();
        } catch (NoSuchFieldException
                | SecurityException
                | IllegalAccessException
                | IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
}
