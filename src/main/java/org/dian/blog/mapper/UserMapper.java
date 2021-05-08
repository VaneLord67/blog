package org.dian.blog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.dian.blog.entity.User;
import org.dian.blog.entity.dto.UserIndexDTO;
import org.springframework.stereotype.Component;

/**
 * @author CJR
 * @create 2021-04-16-21:38
 */

@Component
public interface UserMapper {

    @Select("select password from user where userName=#{userName}")
    String getPasswordByUserName(String userName);

    @Select("select blogName from user where userName=#{userName}")
    String getBlogNameByUserName(String userName);

    @Insert("insert into user(userName,password,blogName) values (#{userName},#{password},#{blogName})")
    int insertUser(UserIndexDTO user);

    @Select("select count(*) from user where userName=#{userName}")
    int isExistUser(String userName);
}
