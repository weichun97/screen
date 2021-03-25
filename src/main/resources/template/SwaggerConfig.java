package com.github.weichun97.common.swagger.config;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
/**
 * @author cocoyang
 * @version 1.0
 **/
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String description;

    /**
     * 创建获取api应用
     * @return
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder pb = new ParameterBuilder();
        pb.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("Bearer ").build();
        List<Parameter> params = Arrays.asList(pb.build());
        HashSet<String> strings = new HashSet<>();
        strings.add("application/json");
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(params)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.weichun97"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title(description+"-api文档")
                        .description(description+"-api文档")
                        .version("1.0")
                        .build()).produces(strings);
    }


}


