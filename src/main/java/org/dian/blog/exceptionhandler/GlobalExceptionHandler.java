package org.dian.blog.exceptionhandler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.dian.blog.util.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CJR
 * @create 2021-04-27-0:27
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response error(Exception e) {
        e.printStackTrace();
        return Response.error().messsage("执行全局异常处理");
    }

    // 自定义异常处理
    @ExceptionHandler(BlogException.class)
    @ResponseBody
    public Response error(BlogException e) {
        return Response.error().messsage("运行时异常");
    }

    @ExceptionHandler(JWTVerificationException.class)
    @ResponseBody
    public Response error(JWTVerificationException e){
        return Response.error().messsage("jwt令牌验证失败");
    }
}