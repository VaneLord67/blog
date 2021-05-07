package org.dian.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dian.blog.entity.dto.ArticleDTO;
import org.dian.blog.service.ArticleService;
import org.dian.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Console;

/**
 * @author CJR
 * @create 2021-04-18-21:21
 */
@CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
@Slf4j
@RestController
@RequestMapping("/article")
@Api(tags = "文章模块controller")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @ApiOperation("发表文章路由")
    @PostMapping("/publishArticle")
    public Response publishArticle(@RequestBody ArticleDTO articleDTO, HttpServletRequest request){
        return articleService.publishArticle(articleDTO,request);
    }

    @ApiOperation("删除文章路由")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "文章主键",required = true),})
    @GetMapping("/deleteArticle")
    public Response deleteArticle(HttpServletRequest request,
                                    @RequestParam("id")String id){
        return articleService.deleteArticle(request,id);
    }

    @ApiOperation("更新文章路由")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "文章主键",required = true),})
    @PostMapping("/updateArticle")
    public Response updateArticle(@RequestBody ArticleDTO newArticleDTO,HttpServletRequest request,
                                    @RequestParam("id") String id){
        return articleService.updateArticle(newArticleDTO,request,id);
    }

    @ApiOperation("查询所有文章路由")
    @GetMapping("/queryAllArticle")
    public Response queryAllArticle(HttpServletRequest request){
        log.info("query");
        return articleService.queryAllArticle(request);
    }

    @ApiOperation("查询文章详情路由")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "文章主键",required = true),})
    @GetMapping("/queryArticle")
    public Response queryArticle(@RequestParam("id") String id,
                               HttpServletRequest request){
        return articleService.queryArticle(request,id);
    }

}
