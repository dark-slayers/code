package person.liuxx.learn.code.vm.classfile.cp;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月8日 下午5:42:08
 * @since 1.0.0
 */
public class UTF8Info implements ConstantInfo
{
    private int tag;
    private int length;
    private int bytes;

    public int getTag()
    {
        return tag;
    }

    public void setTag(int tag)
    {
        this.tag = tag;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getBytes()
    {
        return bytes;
    }

    public void setBytes(int bytes)
    {
        this.bytes = bytes;
    }

    @Override
    public String getType()
    {
        return "CONSTANT_Utf8_info";
    }

    @Override
    public String getInfo()
    {
        // TODO 自动生成的方法存根
        return null;
    }
}
