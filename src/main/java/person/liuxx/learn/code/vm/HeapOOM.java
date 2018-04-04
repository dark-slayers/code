package person.liuxx.learn.code.vm;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2018年3月29日 下午2:32:30
* @since 1.0.0 
*/
public class HeapOOM
{
    static class OOMObject{
        static String a=new String("DSFLGJSDKLJ");
    }
    public static void main(String[] args){
        List<OOMObject> list=new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
