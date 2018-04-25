package person.liuxx.learn.code.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月18日 下午3:06:08
 * @since 1.0.0
 */
@Configuration
@ComponentScan("person.liuxx.learn.code.spring.aop")
@EnableAspectJAutoProxy
public class AopConfig
{
    @Primary
    @Bean(name = "annotationService")
    @Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
    public AnnotationService service1()
    {
        return new AnnotationService();
    }

    @Bean(name = "methodService")
    @Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
    public MethodService service2()
    {
        return new MethodService();
    }
}
