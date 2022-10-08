package person.liuxx.learn.code.base.number;

import java.math.BigDecimal;

/** 
* @author  
* @version 1.0.0<br>创建时间：2022年7月5日 下午3:25:51
* @since 1.0.0 
*/
public class NumberChangeLearn {
    /** 
    * @author  
    * @version 1.0.0<br>创建时间：2022年7月5日 下午3:25:51
    * @since 1.0.0 
    * @param args
    */
    public static void main(String[] args) {
        double d=88.88;
        long n=99L;
        System.out.println((long)d);
        System.out.println((double)n);
        System.out.println(9.9999<10);
        Double dd=4.1;
        long ss=(long) (dd * 100);
        System.out.println(ss);
        BigDecimal num=new BigDecimal(dd.toString());
        System.out.println(num);
        ss=num.multiply(new BigDecimal(100)).longValue();
        System.out.println(ss);
    }
}
