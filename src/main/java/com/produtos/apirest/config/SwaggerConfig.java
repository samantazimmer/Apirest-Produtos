package com.produtos.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Object RequestHanlerSelectors;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHanlerSelectors.basePackge("com.produtos.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST",
                "API REST cdastro de produtos.",
                "1.0",
                "Terms of Service",
                "Apache Licence Version 2",
                new Contact("Samanta Zimmer", "SamantaZimmer@gmail.com"),
                "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
