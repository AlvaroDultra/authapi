package com.authapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI authApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AuthAPI — Autenticação & Autorização com JWT")
                        .description("""
                                API REST para cadastro, login, refresh de token e controle de acesso por roles.
                                Tecnologias: Spring Boot 3, Spring Security 6, JWT (jjwt), Spring Data JPA, PostgreSQL e SpringDoc.
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Álvaro Dultra")
                                .url("https://www.linkedin.com/in/alvarodultra/")
                                .email("contato@exemplo.com"))
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório do projeto")
                        .url("https://github.com/seu-usuario/authapi"));
    }
}
