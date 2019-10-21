package person.liuxx.learn.code.vm.classfile;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月14日 上午10:15:20
 * @since 1.0.0
 */
public class FieldInfo
{
    private final int accessFlags, nameIndex, descriptorIndex, attributesCount;

    public FieldInfo(Queue<Integer> queue)
    {
        accessFlags = QueueUtil.getInt(queue, 2);
        nameIndex = QueueUtil.getInt(queue, 2);
        descriptorIndex = QueueUtil.getInt(queue, 2);
        attributesCount = QueueUtil.getInt(queue, 2);
    }

    public int getAccessFlags()
    {
        return accessFlags;
    }

    public int getNameIndex()
    {
        return nameIndex;
    }

    public int getDescriptorIndex()
    {
        return descriptorIndex;
    }

    public int getAttributesCount()
    {
        return attributesCount;
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

    public void show(ConstantPool pool)
    {
        AccessFlagsUtil.show("FieldInfoAccessFlags", getAccessFlagsMap(), accessFlags);
        System.out.println("nameIndex : " + nameIndex);
        pool.show("name : ", nameIndex);
        System.out.println("descriptorIndex : " + descriptorIndex);
        pool.show("descriptor : ", descriptorIndex);
        System.out.println("attributesCount : " + attributesCount);
    }

    @Override
    public String toString()
    {
        return "FieldInfo [accessFlags=" + accessFlags + ", nameIndex=" + nameIndex
                + ", descriptorIndex=" + descriptorIndex + ", attributesCount=" + attributesCount
                + "]";
    }
}
