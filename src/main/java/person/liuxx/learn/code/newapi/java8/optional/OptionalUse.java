package person.liuxx.learn.code.newapi.java8.optional;

import java.util.Objects;
import java.util.Optional;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月16日 下午4:04:24
 * @since 1.0.0
 */
public class OptionalUse
{
    public static void nullAndEmpty()
    {
        Optional<String> op1 = Optional.empty();
        Optional<String> op2 = Optional.ofNullable(null);
        // op1==op2 : true
        System.out.println(op1 == op2);
        // Objects.equals(op1, op2) : true
        System.out.println(Objects.equals(op1, op2));
    }
}
