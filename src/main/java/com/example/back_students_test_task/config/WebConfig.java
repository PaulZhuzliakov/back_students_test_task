package com.example.back_students_test_task.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration

public class WebConfig implements WebMvcConfigurer{

    @Autowired
    private ObjectProvider<HttpMessageConverters> messageConvertersProvider;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    /**
     * аннотация @EnableWebMvc делает неактивной конфигурацию "spring.jackson.property-naming-strategy=SNAKE_CASE"
     * чтобы стратегия наименования полей при сериализации работала, пришлось переопределить этот метод
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        this.messageConvertersProvider
                .ifAvailable((customConverters) -> converters.addAll(customConverters.getConverters()));
    }

}
