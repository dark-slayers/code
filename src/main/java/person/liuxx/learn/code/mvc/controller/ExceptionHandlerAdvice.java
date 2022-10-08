package person.liuxx.learn.code.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import person.liuxx.util.service.exception.BaseExceptionHandlerAdvice;
import person.liuxx.util.service.exception.SaveException;
import person.liuxx.util.service.reponse.Response;

/**
 * @author 刘湘湘
 * 
 * @version 1.0.0<br>
 *          创建时间：2017年10月25日 上午10:07:54
 * 
 * @since 1.0.0
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice extends BaseExceptionHandlerAdvice {
    @ExceptionHandler({ Exception.class })
    public Response exceptionHandler(Exception e) {
        String exceptionClassName = e.getClass().getName();
        List<String> exceptionClassNameList = getExceptionClassNameList();
        if (exceptionClassNameList.contains(exceptionClassName)) {
            return baseExceptionHandler(e);
        } else {
            switch (exceptionClassName) {
                case "person.liuxx.util.service.exception.SaveException": {
                    SaveException e1 = (SaveException) e;
                    return Response.error(e1.getMessage());
                }
                default: {
                    return Response.error();
                }
            }
        }
    }
}
