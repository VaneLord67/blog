package org.dian.blog.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJR
 * @create 2021-04-27-0:08
 */
@ApiModel("响应类")
@Data
public class Response {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    private Response() {
    }

    // 访问成功结果
    public static Response ok() {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage("成功");
        return response;
    }

    // 访问不成功结果
    public static Response error() {
        Response response = new Response();
        response.setSuccess(false);
        response.setMessage("失败");
        return response;
    }

    public Response data(String s, Object o) {
        this.data.put(s, o);
        return this;
    }

    public Response data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    public Response messsage(String msg) {
        this.setMessage(msg);
        return this;
    }

}