package org.dian.blog.interceptor;

import org.dian.blog.service.impl.UserServiceImpl;
import org.dian.blog.util.Response;
import org.dian.blog.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CJR
 * @create 2021-04-18-19:26
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (userServiceImpl.checkJwt(request)) {
            return true;
        } else {
            ResponseUtil.out(response,Response.error().messsage("token认证失败"));
            return false;
        }
    }
}
