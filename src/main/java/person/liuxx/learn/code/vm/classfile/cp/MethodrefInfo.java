package person.liuxx.learn.code.vm.classfile.cp;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年10月8日 下午5:52:38
 * @since 1.0.0
 */
public class MethodrefInfo implements ConstantInfo
{
    private int index1;
    private int index2;

    @Override
    public String getType()
    {
        return "CONSTANT_Methodref_info";
    }

    @Override
    public String getInfo()
    {
        return "ClassInfo index: "+index1+",NameAndType index : "+index2;
    }
}
