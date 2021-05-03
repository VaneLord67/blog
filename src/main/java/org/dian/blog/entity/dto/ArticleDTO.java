package org.dian.blog.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author CJR
 * @create 2021-04-27-20:55
 */
@Data
@ApiModel(value = "文章DTO类")
public class ArticleDTO {
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String content;
}
