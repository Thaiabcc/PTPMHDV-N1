package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Cấu hình cho tất cả các API
                .allowedOrigins("http://localhost:3000") // Địa chỉ của ứng dụng React
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}