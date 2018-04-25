package person.liuxx.learn.code.spring.aop;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月18日 下午4:29:19
 * @since 1.0.0
 */
public class MethodService implements AopService
{
    public void add()
    {
        System.out.println("MethodService add !");
    }
}
