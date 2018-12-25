package person.liuxx.learn.code.base.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author 刘湘湘
 * @version 1.4.2<br>
 *          创建时间：2018年12月13日 下午1:35:56
 * @since 1.4.2
 */
public class BigDecimalFormatDemo
{
    public void run()
    {
        DecimalFormat df1 = new DecimalFormat("###0.00");
        df1.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df1.format(124.3));
        System.out.println(df1.format(124.315));  // 费解 没有四舍五入
        System.out.println(df1.format(124.325));  // 费解 实现四舍五入
        // 保留两位小数，不足两位则不补零
        DecimalFormat df2 = new DecimalFormat("###0.##");
        System.out.println(df2.format(124.6));
        System.out.println(df2.format(124));
        // 保留两位小数，哪里不足位则补零
        DecimalFormat df3 = new DecimalFormat("000.00");
        System.out.println(df3.format(24));
        // 添加千位分隔符,保留3位小数，不足的补0
        DecimalFormat df4 = new DecimalFormat("#,##0.000");
        System.out.println(df4.format(new BigDecimal(3613.61)));
        System.out.println(df4.format(new BigDecimal(3613.613)));
        System.out.println(df4.format(new BigDecimal(3613.6135)));
        System.out.println(df4.format(new BigDecimal(563456363613.6136)));
        DecimalFormat df5 = new DecimalFormat("#,##0.##");

        System.out.println(df5.format(new BigDecimal(563456363613.6136)));
        System.out.println(df5.format(new BigDecimal(563456363613.6176)));
        System.out.println(df5.format(new BigDecimal(563456363613.00000)));
        System.out.println(df5.format(new BigDecimal(563456363613.1)));
    }
}
