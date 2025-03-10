package aps.caixa_super.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SrpingDocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))).info(new Info()
                        .title("Caixa-Super API")
                        .description("API Rest da aplicação Caixa-Super, contendo as funcionalidades de CRUD de produto, caixa e filtros, além de vendas e autenticacao")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@caixa.super"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://caixa.super/api/licenca")));
    }
}
