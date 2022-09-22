package br.com.alura.forum.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

    /**
     * Docket é um objeto do swagger
     * Anotação Bean para saber que se está exportanto um beand do tipo docket
     *
     * @return
     */
    @Bean
    public Docket forumApi(){

    }

}
