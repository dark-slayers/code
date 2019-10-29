package person.liuxx.learn.code.vm.classfile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2019年9月27日 下午3:15:39
 * @since 1.0.0
 */
public class ReadClassFile
{
    static String p1 = "E:/GitHYC/delivery/target/classes/cn/hyc/mis/delivery/service/impl/PersonPlanServiceImpl.class";
    static String a = "E:/dshell/A.class";
    static String b = "E:/dshell/B.class";
    static String c = "E:/dshell/C.class";
    static String p4 = "E:/GitProject/util/target/classes/person/liuxx/util/base/StringUtil.class";

    /**
     * @author 刘湘湘
     * @version 1.0.0<br>
     *          创建时间：2019年9月27日 下午3:15:39
     * @since 1.0.0
     * @param args
     */
    public static void main(String[] args)
    {
//        test();
        System.out.println("------------------");
        showCF();
    }

    static void showCF()
    {
        Path path = Paths.get(c);
        ClassFile cf = new ClassFile(path);
        cf.show();
    }

    static void test()
    {
        AccessFlagsUtil.test(10);
    }
}
