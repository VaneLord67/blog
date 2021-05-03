package org.dian.blog.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CJR
 * @create 2021-04-27-20:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户DTO类")
public class UserDTO {
    @ApiModelProperty(value = "用户名")
    private String userName;
}
