package com.angela.board.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String DEFAULT_INCLUDE_PATTERN = "/api/*";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build().useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        Lists.newArrayList(
                                new ResponseMessageBuilder()
                                        .code(500)
                                        .message("Server error")
//                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(401)
                                        .message("Unauthorized")
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(403)
                                        .message("Forbidden")
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(404)
                                        .message("Not Found")
                                        .build())
                )
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("AR Line")
                .description("API List")
                .version("1.0")
                .contact(new Contact("popsline", "http://popsline.co.kr", "vito@popsline.co.kr"))
                .build();
    }
}
