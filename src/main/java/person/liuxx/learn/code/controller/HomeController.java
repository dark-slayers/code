package person.liuxx.learn.code.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import person.liuxx.learn.code.response.ErrorResponse;
import person.liuxx.learn.code.response.Person;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年8月11日 下午3:59:56
 * @since 1.0.0
 */
@RestController
public class HomeController
{
    @RequestMapping("/errorinfo")
    public ErrorResponse error()
    {
        return new ErrorResponse(401, 40101, "用户未登录", "认证失败", "more info");
    }

    @RequestMapping("/info")
    public Person info(@RequestParam(value = "age", defaultValue = "25") Integer age)
    {
        if (age > 50)
        {
            throw new OldAgeException("age old !");
        }
        return new Person(1L, "Axe", age, "USA");
    }

    @ExceptionHandler(OldAgeException.class)
    public ErrorResponse exceptionHandler()
    {
        ErrorResponse resp = new ErrorResponse(415, 41501, "输入的年龄值错误", "年龄值超出范围", "more info");
        return resp;
    }
}

class OldAgeException extends RuntimeException
{
    /**
     * @param string
     */
    public OldAgeException(String string)
    {
        super(string);
    }

    /**
     * 
     */
    private static final long serialVersionUID = -4449471943380209687L;
}
