package person.liuxx.learn.code.vm.classfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月16日 下午5:00:20
 * @since 1.0.0
 */
public class FieldInfoTable
{
    private final List<FieldInfo> fieldInfoList;

    public FieldInfoTable(Queue<Integer> queue)
    {
        int number = QueueUtil.getInt(queue, 2);
        fieldInfoList = new ArrayList<>();
        for (int i = 0; i < number; i++)
        {
            FieldInfo info = new FieldInfo(queue);
            fieldInfoList.add(info);
        }
    }

    @Override
    public String toString()
    {
        return "FieldInfoTable [fieldInfoList=" + fieldInfoList + "]";
    }

    void show(ConstantPool pool)
    {
        int size = fieldInfoList.size();
        System.out.println("FieldInfoTable number : " + size);
        System.out.println("FieldInfoTable : " + this);
        for (FieldInfo info : fieldInfoList)
        {
            info.show(pool);
        }
    }
}
