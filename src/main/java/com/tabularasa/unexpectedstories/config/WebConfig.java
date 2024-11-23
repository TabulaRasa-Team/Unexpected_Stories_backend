package com.tabularasa.unexpectedstories.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000",
                        "http://10.150.151.211:3000",
                        "http://192.168.0.21:3000",
                        "https://unexpected-stories-front.vercel.app",
                        "https://unexpected-stories-front.vercel.app/") // 허용할 도메인들 설정
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메소드 설정
                .allowedHeaders("*") // 허용할 헤더 설정
                .allowCredentials(true) // 인증정보 허용 여부
                .maxAge(3600); // preflight 요청의 유효시간 설정
    }
}

