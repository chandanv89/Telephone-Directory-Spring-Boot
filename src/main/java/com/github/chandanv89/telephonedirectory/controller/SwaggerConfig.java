package com.github.chandanv89.telephonedirectory.controller;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * The type Swagger config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Posts api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("directory-app")
                .apiInfo(apiInfo())
                .select()
                .paths(postPaths())
                .build();
    }

    private Predicate<String> postPaths() {
        return or(
                regex("/contacts/*"),
                regex("/contactnumbers/*"),
                regex("/emails/*"),
                regex("/*")
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Telephone Directory using Spring Boot")
                .contact(new Contact("Chandan Veerabhadrappa",
                        "https://github.com/chandanv89",
                        null))
                .description("Telephone Directory API reference for developers")
                .termsOfServiceUrl("https://github.com/chandanv89/Telephone-Directory-Spring-Boot/blob/master/LICENSE")
                .license("MIT License")
                .licenseUrl("https://github.com/chandanv89/Telephone-Directory-Spring-Boot/blob/master/LICENSE")
                .version("2018.12")
                .build();
    }
}
