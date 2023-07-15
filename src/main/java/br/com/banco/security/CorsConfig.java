package br.com.banco.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Especifique os caminhos da API que deseja permitir
                .allowedOrigins("*") // Permitir solicitações de qualquer origem (restringir conforme necessário)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir métodos HTTP específicos
                .allowedHeaders("*"); // Permitir todos os cabeçalhos (restringir conforme necessário)
    }
}