package person.liuxx.learn.code.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月23日 下午3:27:24
 * @since 1.0.0
 */
@Configuration
@ComponentScan(
{ "person.liuxx.learn.code.spring.bean", "person.liuxx.learn.code.mvc.service.impl" })
public class BeanConfig
{
    @Primary
    @Bean(name = "service1")
    public BeanService service1()
    {
        return new BeanServiceImpl1();
    }

    @Bean(name = "service2")
    public BeanService service2()
    {
        return new BeanServiceImpl2();
    }
}
