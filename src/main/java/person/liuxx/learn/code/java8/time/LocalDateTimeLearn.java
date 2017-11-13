package person.liuxx.learn.code.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年9月6日 上午11:11:34
 * @since 1.0.0
 */
public class LocalDateTimeLearn
{
    static void timeCompare()
    {
        LocalDateTime a = LocalDateTime.of(2017, Month.SEPTEMBER, 1, 8, 10, 30);
        LocalDateTime b = LocalDateTime.of(2017, Month.SEPTEMBER, 3, 9, 10, 30);
        System.out.println(a.until(b, ChronoUnit.DAYS));
        System.out.println(b.until(a, ChronoUnit.DAYS));
        a = LocalDateTime.of(2017, Month.SEPTEMBER, 1, 18, 10, 30);
        b = LocalDateTime.of(2017, Month.SEPTEMBER, 2, 9, 10, 30);
        System.out.println(a.until(b, ChronoUnit.DAYS));
    }

    static void dateShow()
    {
        LocalDate a = LocalDate.of(2017, Month.SEPTEMBER, 1);
        System.out.println(a);
    }

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2017年9月6日 上午11:11:34
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        dateShow();
    }
}
