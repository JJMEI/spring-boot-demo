package com.meijunjie.springboot.globalexception;

import com.meijunjie.springboot.common.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author meijunjie
 * @date 2018/9/25
 *
 * 新增全局异常处理器，捕捉controller抛出的异常
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult jsonErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        JsonResult result = new JsonResult();
        result.setCode(-9999);
        result.setMessage("服务器繁忙");
        if(e instanceof NoHandlerFoundException){
            result.setCode(-9994);
            result.setMessage("请求资源不存在");
        }
        result.setData(null);
        return result;
    }

}
