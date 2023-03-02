package com.vladrip.ifchat.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {
    private Info apiInfo() {
        return new Info().title("IFChat REST API")
                .description("API for \"IFChat\" chat application")
                .version("0.1")
                .contact(new Contact().name("Vladyslav Ripskyi").email("vladrip12@gmail.com"));
    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(apiInfo());
    }
}
