package org.dian.blog.service;

import org.dian.blog.entity.Article;
import org.dian.blog.entity.dto.ArticleDTO;
import org.dian.blog.util.Response;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CJR
 * @create 2021-04-26-23:58
 */
public interface ArticleService {

    public Response publishArticle(ArticleDTO articleDTO, HttpServletRequest request);

    public Response deleteArticle(HttpServletRequest request,String id);

    public Response updateArticle(ArticleDTO newArticleDTO,HttpServletRequest request,String id);

    public Response queryAllArticle(HttpServletRequest request);

    public Response queryAllArticle(String userName);

    public Response queryArticle(String id);
}
