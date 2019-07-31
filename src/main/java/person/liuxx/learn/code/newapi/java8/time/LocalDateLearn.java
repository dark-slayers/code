package person.liuxx.learn.code.newapi.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年7月31日 上午10:41:18
 * @since 1.0.0
 */
public class LocalDateLearn
{
    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2019年7月31日 上午10:41:18
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.of(2019, 7, 19);
        LocalDate d = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(d);
        System.out.println(changeDate(date));
        System.out.println(changeDate(d));
        show(LocalDate.of(2019, 7, 19));
        show(LocalDate.of(2019, 7, 2));
        show(LocalDate.of(2019, 8, 9));
        show(LocalDate.of(2019, 8, 19));
        show(LocalDate.of(2019, 6, 30));
        show(LocalDate.of(2019, 5, 30));
        show(LocalDate.of(2019, 6, 24));
        show(LocalDate.of(2019, 7, 1));
    }

    private static void show(LocalDate date)
    {
        System.out.println(date + ":" + changeDate(date));
    }

    private static String changeDate(LocalDate date)
    {
        LocalDate firstSunday = LocalDate.of(date.getYear(), date.getMonth(), 1).with(
                TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        if (!date.isAfter(firstSunday))
        {
            return formatDay(date.getMonthValue(), 1);
        }
        LocalDate nextMonday = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        if (!Objects.equals(nextMonday.getMonth(), date.getMonth()) && nextMonday
                .getDayOfMonth() != 1)
        {
            return formatDay(nextMonday.getMonthValue(), 1);
        }
        long weekNumber = firstSunday.until(date, ChronoUnit.DAYS) / 7 + 1;
        if (!Objects.equals(date.getDayOfWeek(), DayOfWeek.SUNDAY))
        {
            weekNumber = weekNumber + 1;
        }
        return formatDay(date.getMonthValue(), (int) weekNumber);
    }

    private static String formatDay(int month, int week)
    {
        return month + "月第" + week + "周";
    }
}
