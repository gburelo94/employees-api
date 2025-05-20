package com.twobrains.employees_api.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI employeeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Service API")
                        .description("API REST para gestión de empleados")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Wendy Gabriela Cobo Burelo")
                                .email("gaby.burelo@outlook.com"))
                );
    }
}
