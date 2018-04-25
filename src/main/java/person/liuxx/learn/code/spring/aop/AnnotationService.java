package person.liuxx.learn.code.spring.aop;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月18日 下午3:14:52
 * @since 1.0.0
 */

public class AnnotationService implements AopService
{
    @AopAction(name = "注解拦截的Add操作")
    public void add()
    {
        System.out.println("AnnotationService add !");
    }
}
