package person.liuxx.learn.code.vm.classfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月8日 下午2:58:42
 * @since 1.0.0
 */
public class ConstantPool
{
    private final List<ConstantInfo> constantInfoList;
    private Queue<Integer> queue;

    public ConstantPool( Queue<Integer> q,int number)
    {
        constantInfoList = new ArrayList<>();
        queue = q;
        for (int i = 0; i < number; i++)
        {
            ConstantInfo info = new ConstantInfo(queue);
            constantInfoList.add(info);
        }
    }

    public List<ConstantInfo> getConstantInfoList()
    {
        return constantInfoList;
    }

    @Override
    public String toString()
    {
        return "ConstantPool [constantInfoList=" + constantInfoList + "]";
    }
    
}
