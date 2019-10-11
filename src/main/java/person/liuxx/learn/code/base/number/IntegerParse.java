package person.liuxx.learn.code.base.number;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2019年10月10日 下午3:35:05
* @since 1.0.0 
*/
public class IntegerParse
{
    public static void main(String[] args){
        int i=0x0021;
        int s=0x1000|0x2000|0x4000;
        System.out.println(Integer.toHexString(s));
    }
}
