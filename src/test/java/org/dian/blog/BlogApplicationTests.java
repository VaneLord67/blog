package org.dian.blog;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.dian.blog.entity.User;
import org.dian.blog.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@SpringBootTest
class BlogApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("sql查询结果：{}" ,aLong);
    }

//    @Test
//    void testJwt(){
//        long expire = 120;
//        String secret = "Dian";         //密钥
//        Date now = new Date();
//        Date expireDate = new Date(now.getTime() + expire * 1000);
//        User user = new User("nihao", "123");
//
//        Algorithm algorithmHS = Algorithm.HMAC256(secret);
//
//        String token = JWT.create()
//                .withIssuer("CJR")          //签发人
//                .withClaim("userId",user.getUserName())
//                .withClaim("password",user.getPassword())
//                .withExpiresAt(expireDate)
//                .sign(algorithmHS);
//
//        System.out.println(token);
//
//        DecodedJWT jwt = JWT.decode(token);
//        Claim userId = jwt.getClaim("userId");
//        Claim password = jwt.getClaim("password");
//
//        System.out.println(userId);
//        System.out.println(password);
//
////        String jsonString = JSON.toJSONString(user);
////        System.out.println("jsonString -->" + jsonString);
//    }

    @Test
    void testMD5(){
        String md5Digest = DigestUtils.md5DigestAsHex("123".getBytes(StandardCharsets.UTF_8));
        System.out.println(md5Digest.length());
    }

    @Autowired
    ArticleServiceImpl articleServiceImpl;
    @Test
    void testQueryAllArticle(){
//        User user = new User("zhangsan", "12345");
//        Article[] articles = articleServiceImpl.queryAllArticle(user);

//        String jsonString = JSON.toJSONString(articles);
//        System.out.println(jsonString);
    }





}


