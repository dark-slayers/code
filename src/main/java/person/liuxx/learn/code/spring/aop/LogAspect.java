package person.liuxx.learn.code.spring.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月18日 下午5:25:02
 * @since 1.0.0
 */
@Aspect
@Component
public class LogAspect
{
    @Pointcut("@annotation(person.liuxx.learn.code.spring.aop.AopAction)")
    public void annotationPointCut()
    {
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint)
    {
        MethodSignature signture = (MethodSignature) joinPoint.getSignature();
        Method method = signture.getMethod();
        AopAction action = method.getAnnotation(AopAction.class);
        System.out.println("DEBUG:" + action);
        System.out.println("注解式拦截：" + action.name());
    }

    @Before("execution(* person.liuxx.learn.code.spring.aop.MethodService.*(..))")
    public void before(JoinPoint joinPoint)
    {
        MethodSignature signture = (MethodSignature) joinPoint.getSignature();
        Method method = signture.getMethod();
        System.out.println("方法式拦截：" + method.getName());
    }
}
