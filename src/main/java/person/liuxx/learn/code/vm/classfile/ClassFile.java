package person.liuxx.learn.code.vm.classfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月10日 上午11:44:43
 * @since 1.0.0
 */
public class ClassFile
{
    private Queue<Integer> queue;
    private final String magicNumber;
    private final int masterVersionNumber, slaveVersionNumber;
    private final ConstantPool constantPool;
    private int accessFlags;
    private final int thisClassIndex, superClassIndex, interfaceCount;
    private List<Integer> interfaceIndexList;
    private final FieldInfoTable fieldInfoTable;

    public ClassFile(Path path)
    {
        queue = initQueue(getByteArray(path));
        magicNumber = QueueUtil.hexString(queue, 4);
        slaveVersionNumber = QueueUtil.getInt(queue, 2);
        masterVersionNumber = QueueUtil.getInt(queue, 2);
        constantPool = new ConstantPool(queue);
        accessFlags = QueueUtil.getInt(queue, 2);
        thisClassIndex = QueueUtil.getInt(queue, 2);
        superClassIndex = QueueUtil.getInt(queue, 2);
        interfaceCount = QueueUtil.getInt(queue, 2);
        interfaceIndexList = new ArrayList<>();
        for (int i = 0; i < interfaceCount; i++)
        {
            interfaceIndexList.add(QueueUtil.getInt(queue, 2));
        }
        fieldInfoTable = new FieldInfoTable(queue);
    }

    private byte[] getByteArray(Path path)
    {
        try
        {
            InputStream input = Files.newInputStream(path);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            IOUtils.copy(input, out);
            return out.toByteArray();
        } catch (IOException e)
        {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private Queue<Integer> initQueue(byte[] array)
    {
        Queue<Integer> result = new LinkedList<Integer>();
        for (byte b : array)
        {
            result.add((int) b);
        }
        return result;
    }

    public String getMagicNumber()
    {
        return magicNumber;
    }

    public int getSlaveVersionNumber()
    {
        return slaveVersionNumber;
    }

    public int getMasterVersionNumber()
    {
        return masterVersionNumber;
    }

    public ConstantPool getConstantPool()
    {
        return constantPool;
    }

    public int getAccessFlags()
    {
        return accessFlags;
    }

    public int getThisClassIndex()
    {
        return thisClassIndex;
    }

    public int getSuperClassIndex()
    {
        return superClassIndex;
    }

    public int getInterfaceIndex()
    {
        return interfaceCount;
    }

    public FieldInfoTable getFieldInfoTable()
    {
        return fieldInfoTable;
    }

    private Map<Integer, String> getClassAccessFlagsMap()
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(0x0001, "ACC_PIUBLIC");
        map.put(0x0010, "ACC_FINAL");
        map.put(0x0020, "ACC_SUPER");
        map.put(0x0200, "ACC_INTERFACE");
        map.put(0x0400, "ACC_ABSTRACT");
        map.put(0x1000, "ACC_SYNTHETIC");
        map.put(0x2000, "ACC_ANNOTATION");
        map.put(0x4000, "ACC_ENUM");
        return map;
    }

    public void show()
    {
        System.out.println("magicNumber : " + getMagicNumber());
        boolean isClassFile = Objects.equals("cafebabe", getMagicNumber());
        if (!isClassFile)
        {
            System.out.println("文件并非正常的Class文件格式！");
            return;
        }
        System.out.println("versionNumber : " + getMasterVersionNumber() + "."
                + getSlaveVersionNumber());
        getConstantPool().show();
        AccessFlagsUtil.show("accessFlags", getClassAccessFlagsMap(), accessFlags);
        showClassIndex();
        getFieldInfoTable().show(getConstantPool());
    }

    private void showClassIndex()
    {
        constantPool.show("thisClassIndex", thisClassIndex);
        constantPool.show("superClassIndex", superClassIndex);
        System.out.println("interfaceCount : " + interfaceCount);
        for (int i = 0; i < interfaceCount; i++)
        {
            constantPool.show("interface" + (i + 1), interfaceIndexList.get(i));
        }
    }
}
