package person.liuxx.learn.code.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月18日 下午2:42:22
 * @since 1.0.0
 */
@Service
public class AopDemo
{
    @Autowired
    @Qualifier("annotationService")
    private AnnotationService service1;
    @Autowired
    @Qualifier("methodService")
    private MethodService service2;

    public void run()
    {
        service1.add();
        System.out.println("-----------");
        service2.add();
    }
}
