package org.dian.blog.service;

import org.dian.blog.entity.User;
import org.dian.blog.entity.dto.UserIndexDTO;
import org.dian.blog.util.Response;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CJR
 * @create 2021-04-26-23:44
 */
public interface UserService {
    String getPasswordByUserName(String userName);
    Response register(UserIndexDTO userIndexDTO);
    Response login(UserIndexDTO userIndexDTO);
    boolean checkJwt(HttpServletRequest request);
    String getJwt(UserIndexDTO user);
    String getUserNameFromJWT(HttpServletRequest request);
    String getUserNameFromJWT(String jwtString);
    boolean isExistUser(String userName);
}
