package person.liuxx.learn.code.base;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年8月2日 下午4:29:08
 * @since 1.0.0
 */
public class FinalDemo
{
    private final String a;
    private final String f1="AAA";
    private static final String b;
    static
    {
        b = "2";
    }

    FinalDemo()
    {
        a = "1";
        // b="2";
    }

    void updateFinal()
    {
       
        try
        {
            Field field = this.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(this, "Hello");
            field = this.getClass().getDeclaredField("f1");
            field.setAccessible(true);
            field.set(this, "ZZZ");
            field = this.getClass().getDeclaredField("b");
            Field modifiers = field.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);//fianl标志位置0
            field.setAccessible(true);
            field.set(this, "ZZZ");
//            System.out.println(field.get(this));
        } catch (IllegalArgumentException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        // p.printName();
        catch (NoSuchFieldException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (SecurityException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
    void show(){
        System.out.println("-------show-----");
        System.out.println("a ： "+a);
        System.out.println("f1 ： "+f1);
        System.out.println("b ： "+b);
        System.out.println("-------show-----");
    }

    public static void main(String[] args)
    {
        FinalDemo f = new FinalDemo();f.show();
        f.updateFinal();
        f.show();
    }
}
