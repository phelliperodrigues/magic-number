package com.phellipe.magicnumber.condif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(SWAGGER_2)
                .select()
                .apis( basePackage("com.phellipe.magicnumber.controller") )
                .paths(any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Magic Numbers API")
                .description("Descubra os numeros magicos entre o range do array")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact("Phellipe Rodrigues",
                "http://github.com/phelliperodrigues",
                "phelliperodrigues.dev@gmail.com");
    }
}
