package org.dian.blog.service.impl;

import org.dian.blog.entity.Article;
import org.dian.blog.entity.dto.ArticleDTO;
import org.dian.blog.entity.dto.UserDTO;
import org.dian.blog.mapper.ArticleMapper;
import org.dian.blog.service.ArticleService;
import org.dian.blog.service.UserService;
import org.dian.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * @author CJR
 * @create 2021-04-18-21:48
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserService userService;

    public Response publishArticle(ArticleDTO articleDTO, HttpServletRequest request) {
        Article article = new Article();
        article.setContent(articleDTO.getContent());
        article.setTitle(articleDTO.getTitle());
        String jwt = request.getHeader("Authorization");
        if (article != null && article.getContent() != null && article.getTitle() != null) {
            article.setAuthor(userService.getUserNameFromJWT(jwt));
            article.setPublishTime(new Timestamp(System.currentTimeMillis()));
            if(articleMapper.publishArticle(article) == 0){
                return Response.error();
            }
            return Response.ok();
        }
        return Response.error().messsage("文章标题或内容为空");
    }

    public Response deleteArticle(HttpServletRequest request,String id){
        Article article = new Article();
        String userName = userService.getUserNameFromJWT(request);
        if(userName == null || id == null){
            if(userName == null){
                return Response.error().messsage("未获取到token中的用户名");
            } else {
                return Response.error().messsage("未获取到请求中的id");
            }
        }
        article.setAuthor(userName);
        article.setId(Integer.parseInt(id));
        int deleteCount = articleMapper.deleteArticle(article);
        if(deleteCount == 0){
            return Response.error().messsage("该文章不存在");
        }
        return Response.ok();
    }

    public Response updateArticle(ArticleDTO newArticleDTO,HttpServletRequest request,String id){
        if("-1".equals(id)) {
            return publishArticle(newArticleDTO, request);
        }
        Article article = new Article();
        article.setTitle(newArticleDTO.getTitle());
        article.setContent(newArticleDTO.getContent());
        article.setPublishTime(new Timestamp(System.currentTimeMillis()));
        article.setId(Integer.parseInt(id));
        int updateCount = articleMapper.updateArticle(article);
        if(updateCount == 0){
            return Response.error();
        }
        return Response.ok();
    }

    public Response queryAllArticle(HttpServletRequest request){
        String userName = userService.getUserNameFromJWT(request);
        UserDTO userDTO = new UserDTO(userName);
        HashMap<String, Object> map = new HashMap<>();
        Article[] articles = articleMapper.queryAllArticle(userDTO);
        map.put("articleList",articles);
        return Response.ok().data(map);
    }

    public Response queryAllArticle(String userName){
        UserDTO userDTO = new UserDTO(userName);
        HashMap<String, Object> map = new HashMap<>();
        Article[] articles = articleMapper.queryAllArticle(userDTO);
        map.put("articleList",articles);
        return Response.ok().data(map);
    }

    public Response queryArticle(String id){
        Article article = new Article();
        article.setId(Integer.parseInt(id));
        Article article1 = articleMapper.queryArticle(article);
        return Response.ok().data("article",article1);
    }
}
