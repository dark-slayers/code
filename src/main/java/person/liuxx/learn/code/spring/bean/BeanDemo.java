package person.liuxx.learn.code.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月23日 下午3:33:45
 * @since 1.0.0
 */
@Service
public class BeanDemo
{
    @Autowired
    @Qualifier("service1")
    private BeanService beanService1;
    @Autowired
    @Qualifier("service2")
    private BeanService beanService2;

    public void run()
    {
        beanService1.run();
        System.out.println("------");
        beanService2.run();
    }
}
