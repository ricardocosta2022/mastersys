package dev.ricardo.mastersys.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;



/*
 *  CLASSE DE CONFIGURAÇÃO DO SWAGGER
 *
 * */

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Academia API")
                        .description(
                                """
                                   API para gerenciamento de academia, incluindo:
                                   
                                   - Cadastro de alunos
                                   - Matriculas e planos
                                   - Controle financeiro  
                                   - Relatórios gerenciais
                                   
                                   Projeto desenvolvido com Spring Boot   
                                """
                        )
                        .version("V1.0.0")
                        .contact(new Contact()
                                .name("Ricardo Costa")
                                .email("ricardo.dese"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0"))
                )
                .servers(List.of(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor local")))
                .externalDocs(new ExternalDocumentation().description("Documentação do Projeto")
                        .url("github"));
    }


}
