package person.liuxx.learn.code.tool.apache.commons;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.MethodUtils;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月26日 下午1:29:30
 * @since 1.0.0
 */
public class BeanUtilLearn
{
    static void run()
    {
        A a = new A();
        AC ac = new AC();
        String name = "number";
        a.setDate(LocalDate.now());
        a.setName("Class A");
        a.setNumber(33);
        s("a", a);
        // BeanIntrospectionData data = getIntrospectionData(bean.getClass());
        // PropertyDescriptor result = data.getDescriptor(name);
        try
        {
            PropertyDescriptor desc = BeanUtilsBean.getInstance()
                    .getPropertyUtils()
                    .getPropertyDescriptor(a, name);
            // getPropertyDescriptor(a, name);
            System.out.println(desc);
            System.out.println(desc.getReadMethod());
            Method m = MethodUtils.getAccessibleMethod(A.class, desc.getReadMethod());
            System.out.println(m);
            Class<?> clazz = desc.getReadMethod().getDeclaringClass();
            s("clazz", clazz);
            s("clazz", clazz);
            boolean show = BeanUtilsBean.getInstance().getPropertyUtils().isReadable(a, name);
            boolean show2 = BeanUtilsBean.getInstance().getPropertyUtils().isWriteable(a, name);
            System.out.println(show);
            System.out.println(show2);
            BeanUtils.copyProperties(ac, a);
        } catch (IllegalAccessException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        System.out.println(ac);
    }

    static void s(String s, Object o)
    {
        System.out.println(s + " : " + o);
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2018年1月26日 下午1:29:30
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        run();
    }
}
