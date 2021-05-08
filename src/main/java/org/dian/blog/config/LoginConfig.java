package org.dian.blog.config;

import org.dian.blog.interceptor.LoginInterceptor;
import org.dian.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author CJR
 * @create 2021-04-18-19:30
 */
//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//
//    @Bean
//    public LoginInterceptor permissionInterceptor() {
//        return new LoginInterceptor();
//    }
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(permissionInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/swagger-ui.html",
//                        "/error",
//                        "/swagger-resources/**",
//                        "/webjars/**",
//                        "/user/login",
//                        "/user/register",
//                        "/register.html",
//                        "/register",
//                        "/login",
//                        "/login.html",
//                        "/article/queryAllArticle",
//                        "/article/queryArticle",
//                        "/user/info");
//    }
//}
