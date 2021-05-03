package org.dian.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author CJR
 * @create 2021-04-26-21:25
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("文档说明--API接口文档")
                        .description("博客系统")
                        .contact(new Contact("CJR", "https://github.com/VaneLord67", "u202015037@hust.edu.cn"))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.dian.blog"))
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("/api/**")) // 如果适配所有api，可以改为PathSelectors.any()
                .build();
    }

//    private ApiInfo webApiInfo(){
//
//        return new ApiInfoBuilder()
//                .title("博客系统接口文档")
//                .description("博客系统接口文档")
//                .version("1.0")
//                .contact(new Contact("CJR", "https://github.com/VaneLord67", "u202015037@hust.edu.cn"))
//                .build();
//    }

}
