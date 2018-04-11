package person.liuxx.learn.code.java8.optional;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月16日 下午4:04:24
 * @since 1.0.0
 */
public class OptionalUse
{
    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年8月16日 下午4:04:24
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        Optional<String> o = Optional.of("A").map(s ->
        {
            try
            {
                return LocalDate.parse(s);
            } catch (Exception e)
            {
                return null;
            }
        }).map(d -> d.toString());
        System.out.println(o);
        System.out.println(o.get());
    }
}
