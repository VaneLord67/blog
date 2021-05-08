package org.dian.blog.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.dian.blog.entity.User;
import org.dian.blog.entity.dto.UserIndexDTO;
import org.dian.blog.mapper.UserMapper;
import org.dian.blog.service.UserService;
import org.dian.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;

/**
 * @author CJR
 * @create 2021-04-16-21:52
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public static final String SECRET = "Dian";         //密钥

    @Autowired
    UserMapper userMapper;

    public String getPasswordByUserName(String userName){
        return userMapper.getPasswordByUserName(userName);
    }

    public Response login(UserIndexDTO user){

        //将user的密码转化成MD5
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        String requestPassword = user.getPassword();

        //读取mysql中的密码（MD5），并比较
        String password = getPasswordByUserName(user.getUserName());

        if(password!=null && password.equals(requestPassword)) {
            String token = getJwt(user);
            HashMap<String, Object> map = new HashMap<>();
            map.put("jwt", token);

            user.setBlogName(userMapper.getBlogNameByUserName(user.getUserName()));

            map.put("blogName",user.getBlogName());
            return Response.ok().data(map);
        }
        return Response.error().messsage("用户名或密码不正确");
    }

    public Response register(UserIndexDTO user){
        boolean existUser = isExistUser(user.getUserName());
        if(existUser){
            return Response.error().messsage("该用户名已被注册");
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        user.setBlogName(user.getUserName() + "的博客");
        if(userMapper.insertUser(user) == 0){
            return Response.error();
        }
        return Response.ok();
    }

    public boolean checkJwt(HttpServletRequest request){
        String jwtString = request.getHeader("Authorization");
        DecodedJWT decodedJWT = null;
        if(jwtString != null){
            try {
                    Algorithm algorithm = Algorithm.HMAC256(SECRET);
                    JWTVerifier verifier = JWT.require(algorithm)
                            .withIssuer("CJR")
                            .build();
                    decodedJWT = JWT.decode(jwtString);
                    verifier.verify(jwtString);
                } catch (Exception e) {
                if (decodedJWT != null) {
                    log.info("用户{}的jwt已过期", decodedJWT.getClaim("userName").asString());
                    return false;
                }
            }
            if(decodedJWT != null){
                String userName = decodedJWT.getClaim("userName").asString();
                return isExistUser(userName);
            }
        }
        return false;
    }

    public String getJwt(UserIndexDTO user){

        long expire = 60*60*24*7;       //7天有效期
        Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
        Date expireDate = new Date(System.currentTimeMillis() + expire * 1000);

        return JWT.create()
            .withIssuer("CJR")          //签发人
            .withClaim("userName",user.getUserName())
            .withExpiresAt(expireDate)
            .sign(algorithmHS);
    }

    public String getUserNameFromJWT(HttpServletRequest request){
        String jwtString = request.getHeader("Authorization");
        if(jwtString != null){
                DecodedJWT decodedJWT = JWT.decode(jwtString);
                return decodedJWT.getClaim("userName").asString();
        }
        return null;
    }

    public String getUserNameFromJWT(String jwtString){
        if(jwtString != null){
            DecodedJWT decodedJWT = JWT.decode(jwtString);
            return decodedJWT.getClaim("userName").asString();
        }
        return null;
    }

    @Override
    public boolean isExistUser(String userName) {
        return userMapper.isExistUser(userName) > 0;
    }

}
