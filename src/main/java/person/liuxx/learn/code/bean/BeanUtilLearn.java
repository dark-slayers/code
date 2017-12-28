package person.liuxx.learn.code.bean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Objects;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.AbstractConverter;

import person.liuxx.learn.code.bean.po.P;
import person.liuxx.learn.code.bean.po.PDTO;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月30日 上午11:37:19
 * @since 1.0.0
 */
public class BeanUtilLearn
{
    static void copy()
    {
        P p = new P();
        p.setId(1);
        p.setNumber("ASD-01");
        // p.setStartDate(LocalDate.now());
        PDTO po = new PDTO();
        BeanUtilsBean bean = BeanUtilsBean.getInstance();
        bean.getConvertUtils().register(new AbstractConverter()
        {
            @Override
            protected <T> T convertToType(Class<T> type, Object value) throws Throwable
            {
                try
                {
                    if (type.equals(LocalDate.class))
                    {
                        return type.cast(LocalDate.parse(value.toString()));
                    }
                } catch (Exception e)
                {
                }
                return null;
            }

            @Override
            protected Class<?> getDefaultType()
            {
                return LocalDate.class;
            }

            @Override
            protected String convertToString(final Object value) throws Throwable
            {
                if (Objects.isNull(value))
                {
                    return "";
                }
                return value.toString();
            }
        }, LocalDate.class);
        try
        {
            copyProperties(po, p);
            System.out.println(po);
            P p1 = new P();
            bean.copyProperties(p1, po);
            System.out.println(p1);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
        {
            e.printStackTrace();
        }
    }

    static void copyProperties(final Object dest, final Object orig) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException
    {
        BeanUtilsBean bean = BeanUtilsBean.getInstance();
        final PropertyDescriptor[] origDescriptors = bean.getPropertyUtils().getPropertyDescriptors(
                orig);
        for (PropertyDescriptor origDescriptor : origDescriptors)
        {
            final String name = origDescriptor.getName();
            final Class<?> propType = origDescriptor.getPropertyType();
            if ("class".equals(name))
            {
                continue; // No point in trying to set an object's class
            }
            if (bean.getPropertyUtils().isReadable(orig, name) && bean.getPropertyUtils()
                    .isWriteable(dest, name))
            {
                try
                {
                    final Object value = bean.getPropertyUtils().getSimpleProperty(orig, name);
                    if (Objects.equals(LocalDate.class, propType) && Objects.isNull(value))
                    {
                        bean.copyProperty(dest, name, "");
                    } else
                    {
                        bean.copyProperty(dest, name, value);
                    }
                } catch (final NoSuchMethodException e)
                {
                    // Should not happen
                }
            }
        }
    }

    public static void main(String[] args)
    {
        copy();
    }
}
