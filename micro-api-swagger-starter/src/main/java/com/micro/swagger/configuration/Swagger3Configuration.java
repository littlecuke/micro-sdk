package com.micro.swagger.configuration;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJndi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ConditionalOnProperty(value = "micro.swagger3.enable", havingValue = "true")
public class Swagger3Configuration {

    @Value("${micro.swagger3.title}")
    private String title;
    @Value("${micro.swagger3.description}")
    private String description;
    @Value("${micro.swagger3.contact.developer}")
    private String developer;
    @Value("${micro.swagger3.contact.url}")
    private String url;
    @Value("${micro.swagger3.contact.email}")
    private String email;
    @Value("${micro.swagger3.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(developer, url, email))
                .version(version)
                .build();
    }
}
