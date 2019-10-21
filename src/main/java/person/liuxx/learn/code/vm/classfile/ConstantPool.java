package person.liuxx.learn.code.vm.classfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月8日 下午2:58:42
 * @since 1.0.0
 */
public class ConstantPool
{
    private final List<ConstantInfo> constantInfoList;

    public ConstantPool(Queue<Integer> queue)
    {
        constantInfoList = new ArrayList<>();
        int number = QueueUtil.getInt(queue, 2) - 1;
        for (int i = 0; i < number; i++)
        {
            ConstantInfo info = new ConstantInfo(queue);
            constantInfoList.add(info);
        }
        Set<String> set = Stream.of("7", "8", "9", "10", "11").collect(Collectors.toSet());
        for (ConstantInfo info : constantInfoList)
        {
            String tag = info.getList().get(0);
            if (set.contains(tag))
            {
                int desIndex = Integer.parseInt(info.getList().get(1), 16);
                info.setDes(constantInfoList.get(desIndex-1).getDes());
            }
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

    public void show(String filed, int index)
    {
        System.out.println(filed + " : " + index + ",des:" + constantInfoList.get(index - 1)
                .getDes());
    }

    public void show()
    {
        int size = constantInfoList.size();
        System.out.println("constantPoolNumber : " + size);
        System.out.println("pool : " + this);
        for (int i = 1; i < size+1; i++)
        {
            show("index", i);
        }
    }
}
