package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //habilita o módulo de segurança
@Configuration //Spring le e carrega as configurações presentes nessa classe
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //Configurações de autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Permite apenas requisições GET
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/topicos").permitAll()
                .antMatchers(HttpMethod.GET,"/topicos/*").permitAll()
                .anyRequest().authenticated() //requer a autenticação
                .and().formLogin();
    }

    //Configurações de recursos estáticos (requisições para arquivos)
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    //Configurações de autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }
}
