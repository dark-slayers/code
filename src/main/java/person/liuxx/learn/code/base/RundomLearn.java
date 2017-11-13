package person.liuxx.learn.code.base;

import java.util.Random;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2017年11月3日 上午10:12:18
* @since 1.0.0 
*/
public class RundomLearn
{
    /** 
    * @author  刘湘湘 
    * @version 1.0.0<br>创建时间：2017年11月3日 上午10:12:18
    * @since 1.0.0 
    * @param args
    */
    public static void main(String[] args)
    {
        Random rand=new Random();
        for(int i=0;i<30;i++){
            System.out.print(rand.nextInt(11)+", ");
        }
    }
}
