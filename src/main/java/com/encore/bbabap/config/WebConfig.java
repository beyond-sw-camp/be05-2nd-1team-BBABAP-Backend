package com.encore.bbabap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/bbabap/**")
                .allowedOrigins("http://localhost:8080") // 허용할 오리진을 명시
                .allowedMethods("GET", "POST") // 허용할 메소드를 명시
                .allowedHeaders("header1", "header2", "header3") // 허용할 헤더를 명시
                .allowCredentials(true); // 인증정보를 허용할지 여부를 명시
    }
}
