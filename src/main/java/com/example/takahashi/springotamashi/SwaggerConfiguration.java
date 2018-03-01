package com.example.takahashi.springotamashi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.google.common.base.Predicate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.*;
@EnableSwagger2

@Configuration
public class SwaggerConfiguration
{
    @Bean
    public Docket publicDocument()
    {
        return new Docket( DocumentationType.SWAGGER_2 ).groupName( "public" )
                .select()
                .paths( paths() )
                .build()
                .apiInfo( apiInfo() );
    }

    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "My REST API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                "myeaddress@company.com",
                "License of API",
                "API license URL");
        return apiInfo;
    }

    private Predicate<String> paths() {
    	 return or(containsPattern("/api*"));  //APIのエントリポイントを正規表現で指定
    }

}