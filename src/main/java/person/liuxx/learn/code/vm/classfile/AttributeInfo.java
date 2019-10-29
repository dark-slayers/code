package person.liuxx.learn.code.vm.classfile;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月21日 下午5:25:23
 * @since 1.0.0
 */
public class AttributeInfo
{
    private final int nameIndex, attributeLength;
    private final String info;

    public AttributeInfo(Queue<Integer> queue)
    {
        nameIndex = QueueUtil.getInt(queue, 2);
        attributeLength = QueueUtil.getInt(queue, 4);
        info = QueueUtil.hexString(queue, attributeLength);
    }

    public static Map<Integer, String> getAccessFlagsMap()
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(0x0001, "ACC_PIUBLIC");
        map.put(0x0002, "ACC_PRIVATE");
        map.put(0x0004, "ACC_PROTECTED");
        map.put(0x0008, "ACC_STATIC");
        map.put(0x0010, "ACC_FINAL");
        map.put(0x0040, "ACC_VOLATILE");
        map.put(0x0080, "ACC_TRANSIENT");
        map.put(0x1000, "ACC_SYNTHETIC");
        map.put(0x4000, "ACC_ENUM");
        return map;
    }

    public int getNameIndex()
    {
        return nameIndex;
    }

    public int getAttributeLength()
    {
        return attributeLength;
    }

    public String getInfo()
    {
        return info;
    }
}
