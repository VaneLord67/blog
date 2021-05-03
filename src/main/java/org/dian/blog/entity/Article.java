package org.dian.blog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author CJR
 * @create 2021-04-16-20:05
 */

@Data
@ApiModel(value = "文章类")
public class Article {
    @ApiModelProperty(value = "主键")
    private int id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "发表时间")
    private Timestamp publishTime;
}
