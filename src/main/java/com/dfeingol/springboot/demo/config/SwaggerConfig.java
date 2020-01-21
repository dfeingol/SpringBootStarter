package com.dfeingol.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by dfeingol on 1/1/2020.
 * Responsible for configuring swagger
 * To access swagger by URL: http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(getApiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dfeingol.springboot.demo."))
            .paths(PathSelectors.any())
            .build();
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
            .title("Student Course Service Example")
            .description("This page lists all API's of Student Course Management")
            .version("1.0")
            .contact(new Contact("David Feingold", "https://www.linkedin.com/in/dave-feingold-a028893/","softintegrationdf@gmail.com"))
            .build();
  }
}
