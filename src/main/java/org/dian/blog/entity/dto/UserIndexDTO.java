package org.dian.blog.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CJR
 * @create 2021-04-27-21:11
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户DTO类")
public class UserIndexDTO {
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "博客名称")
    private String blogName;
}
