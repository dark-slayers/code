package person.liuxx.learn.code.vm.classfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月8日 上午11:52:02
 * @since 1.0.0
 */
public class ClassFile2
{
    private String[] hexArray;
    private String errorInfo;

    public ClassFile2(Path path)
    {
        init(path);
    }

    void init(Path path)
    {
        byte[] byteArray = getByteArray(path);
        int length = byteArray.length;
        hexArray = new String[length];
        for (int i = 0; i < length; i++)
        {
            hexArray[i] = intToHexString(byteArray[i]);
        }
        if (!hasMagicNumber())
        {
            errorInfo = "非正常Class文件！";
        }
    }

    byte[] getByteArray(Path path)
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
            return null;
        }
    }

    String intToHexString(int i)
    {
        String text = Integer.toHexString(i);
        int length = text.length();
        if (length < 2)
        {
            return "0" + text;
        }
        if (length < 3)
        {
            return text;
        }
        return Integer.toHexString(i).substring(length - 2);
    }

    boolean hasMagicNumber()
    {
        return Objects.equals("cafebabe", hexArray[0] + hexArray[1] + hexArray[2] + hexArray[3]);
    }

    void showHexArray()
    {
        System.out.println(Arrays.toString(hexArray));
    }

    String getErrorInfo()
    {
        return errorInfo;
    }

    int getSlaveVersionNumber()
    {
        return changeToInt(hexArray[4] + hexArray[5]);
    }

    int getMasterVersionNumber()
    {
        return changeToInt(hexArray[6] + hexArray[7]);
    }

    int getConstantPoolNumber()
    {
        return changeToInt(hexArray[8] + hexArray[9]) - 1;
    }

    int changeToInt(String text)
    {
        return Integer.parseInt(text, 16);
    }

    void show()
    {
        System.out.println("is class file : " + hasMagicNumber());
        if (!hasMagicNumber())
        {
            System.out.println("errorInfo : " + getErrorInfo());
            return;
        }
        System.out.println("versionNumber : " + getMasterVersionNumber() + "."
                + getSlaveVersionNumber());
        System.out.println("constantPoolNumber : " + getConstantPoolNumber());
    }
}
