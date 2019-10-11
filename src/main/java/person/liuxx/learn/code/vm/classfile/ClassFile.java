package person.liuxx.learn.code.vm.classfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.Pattern;

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
    private final int masterVersionNumber, slaveVersionNumber, constantPoolNumber;
    private ConstantPool constantPool;
    private String accessFlags;

    public ClassFile(Path path)
    {
        queue = initQueue(getByteArray(path));
        magicNumber = QueueUtil.hexString(queue, 4);
        slaveVersionNumber = QueueUtil.getInt(queue, 2);
        masterVersionNumber = QueueUtil.getInt(queue, 2);
        constantPoolNumber = QueueUtil.getInt(queue, 2) - 1;
        constantPool = new ConstantPool(queue, constantPoolNumber);
        accessFlags = QueueUtil.hexString(queue, 2);
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

    public int getConstantPoolNumber()
    {
        return constantPoolNumber;
    }

    public ConstantPool getConstantPool()
    {
        return constantPool;
    }

    public String getAccessFlags()
    {
        return accessFlags;
    }

    public void showAccessFlags()
    {
        List<String> flags = new ArrayList<>();
        LinkedList<String> f = Pattern.compile("").splitAsStream(accessFlags).collect(
                LinkedList::new, LinkedList::add, LinkedList::addAll);
        int i = Integer.valueOf(f.pop());
        if (i % 2 == 1)
        {
            flags.add("ACC_SYNTHETIC");
            i = i - 1;
        }
        if (i >= 4)
        {
            flags.add("ACC_ENUM");
            i = i - 4;
        }
        if (i == 2)
        {
            flags.add("ACC_ANNOTATION");
        }
        i = Integer.valueOf(f.pop());
        if (i >= 4)
        {
            flags.add("ACC_ABSTRACT");
            i = i - 4;
        }
        if (i == 2)
        {
            flags.add("ACC_INTERFACE");
        }
        i = Integer.valueOf(f.pop());
        if (i % 2 == 1)
        {
            flags.add("ACC_FINAL");
            i = i - 1;
        }
        if (i == 2)
        {
            flags.add("ACC_SUPER");
        }
        i = Integer.valueOf(f.pop());
        if (i == 1)
        {
            flags.add("ACC_PIUBLIC");
        }
        System.out.println("accessFlags : " + flags);
    }

    void show()
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
        System.out.println("constantPoolNumber : " + getConstantPoolNumber());
        System.out.println("pool : " + getConstantPool());
        System.out.println("accessFlags : " + getAccessFlags());
        showAccessFlags();
    }
}
