package person.liuxx.learn.code.mvc.service.impl;

import org.springframework.stereotype.Service;

import person.liuxx.learn.code.base.number.BigDecimalFormatDemo;
import person.liuxx.learn.code.mvc.Demo;
import person.liuxx.learn.code.mvc.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService
{
    @Override
    public void run()
    {
        Demo demo=new BigDecimalFormatDemo();
        demo.run();
    }
}
