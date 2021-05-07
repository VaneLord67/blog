package org.dian.blog.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.dian.blog.entity.dto.UserIndexDTO;
import org.dian.blog.service.UserService;
import org.dian.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

/**
 * @author CJR
 * @create 2021-04-16-20:12
 */

@CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
@Api(tags = "用户模块controller")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("注册路由")
    @PostMapping("/register")
    public Response registerController(@RequestBody UserIndexDTO userIndexDTO){
        log.info("User:{}",userIndexDTO.getUserName());
        log.info("password:{}",userIndexDTO.getPassword());
       return userService.register(userIndexDTO);
    }

    @ApiOperation("登录路由")
    @PostMapping("/login")
    public Response loginControl(@RequestBody UserIndexDTO userIndexDTO){
        log.info("someone login");
        log.info("User:{}",userIndexDTO.getUserName());
        log.info("password:{}",userIndexDTO.getPassword());
        return userService.login(userIndexDTO);
    }
}
