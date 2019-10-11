package person.liuxx.learn.code.vm.classfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月9日 下午2:46:55
 * @since 1.0.0
 */
public class ConstantInfo
{
    private final List<String> list;
    private int[] typeArray1 =
    { 2, 1 };
    private int[] typeArray2 =
    { 4 };
    private int[] typeArray3 =
    { 4 };
    private int[] typeArray4 =
    { 8 };
    private int[] typeArray5 =
    { 8 };
    private int[] typeArray6 =
    { 2 };
    private int[] typeArray7 =
    { 2 };
    private int[] typeArray8 =
    { 2, 2 };
    private int[] typeArray9 =
    { 2, 2 };
    private int[] typeArray10 =
    { 2, 2 };
    private int[] typeArray11 =
    { 2, 2 };
    private int[] typeArray12 =
    { 1, 2 };
    private int[] typeArray13 =
    { 2 };
    private int[] typeArray14 =
    { 2, 2 };

    public ConstantInfo(Queue<Integer> queue)
    {
        list = new ArrayList<>();
        int tag = queue.poll();
        list.add(Integer.toString(tag));
        switch (tag)
        {
        case 1:
            {
                int length=QueueUtil.getInt(queue, typeArray1[0]);
                list.add(Integer.toString(length));
                list.add(QueueUtil.hexString(queue, length));
                break;
            }
        case 3:
            {
                initArray(typeArray2, queue);
                break;
            }
        case 4:
            {
                initArray(typeArray3, queue);
                break;
            }
        case 5:
            {
                initArray(typeArray4, queue);
                break;
            }
        case 6:
            {
                initArray(typeArray5, queue);
                break;
            }
        case 7:
            {
                initArray(typeArray6, queue);
                break;
            }
        case 8:
            {
                initArray(typeArray7, queue);
                break;
            }
        case 9:
            {
                initArray(typeArray8, queue);
                break;
            }
        case 10:
            {
                initArray(typeArray9, queue);
                break;
            }
        case 11:
            {
                initArray(typeArray10, queue);
                break;
            }
        case 12:
            {
                initArray(typeArray11, queue);
                break;
            }
        case 15:
            {
                initArray(typeArray12, queue);
                break;
            }
        case 16:
            {
                initArray(typeArray13, queue);
                break;
            }
        case 18:
            {
                initArray(typeArray14, queue);
                break;
            }
        }
    }

    void initArray(int[] typeArray, Queue<Integer> queue)
    {
        for (int i : typeArray)
        {
            list.add(QueueUtil.hexString(queue, i));
        }
    }

    public List<String> getList()
    {
        return list;
    }

    @Override
    public String toString()
    {
        return "ConstantInfo [list=" + list + "]";
    }
}
