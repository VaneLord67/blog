package org.dian.blog.mapper;

import org.apache.ibatis.annotations.*;
import org.dian.blog.entity.Article;
import org.dian.blog.entity.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @author CJR
 * @create 2021-04-18-21:46
 */
@Component
public interface ArticleMapper {

    @Insert("insert into article(title,content,author,publishTime) values (#{title},#{content},#{author},#{publishTime})")
    public int publishArticle(Article article);

    @Delete("delete from article where id=#{id}")
    public int deleteArticle(Article article);

    @Update("update article set title=#{title},content=#{content},publishTime=#{publishTime} where id=#{id}")
    public int updateArticle(Article article);

    @Select("select id,author,title,content,publishTime from article where author=#{userName}")
    public Article[] queryAllArticle(UserDTO userDTO);

    @Select("select id,author,title,content,publishTime from article where id=#{id}")
    public Article queryArticle(Article article);

}
