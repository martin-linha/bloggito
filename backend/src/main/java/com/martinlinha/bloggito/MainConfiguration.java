package com.martinlinha.bloggito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by martinlinha on 22.01.17.
 */
@SpringBootApplication
public class MainConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(MainConfiguration.class, args);
    }

}
