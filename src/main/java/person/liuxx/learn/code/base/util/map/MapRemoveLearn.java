package person.liuxx.learn.code.base.util.map;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月2日 上午9:46:43
 * @since 1.0.0
 */
public class MapRemoveLearn
{
    public static void main(String[] args)
    {
        Map<LocalDate, String> map = new HashMap<>();
        for (int i = 0; i < 30; i++)
        {
            LocalDate date = LocalDate.now().minusDays(i);
            map.put(date, "AAA");
        }
        System.out.println(map);
        LocalDate firstMonthDay = LocalDate.of(LocalDate.now().getYear(), LocalDate.now()
                .getMonth(), 1);
        Iterator<LocalDate> iterator = map.keySet().iterator();
        while (iterator.hasNext())
        {
            LocalDate k = iterator.next();
            if (k.isBefore(firstMonthDay))
            {
                iterator.remove();
            }
        }
        System.out.println(map);
    }
}
