package com.task.order.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
		/*
		 * registry.addMapping("/**") // Apply to all endpoints
		 * .allowedOrigins("http://localhost:4200") // Allow your Angular app's origin
		 * .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow HTTP
		 * methods .allowedHeaders("*") // Allow any headers .allowCredentials(true); //
		 * If you're using cookies or auth headers
		 */    }
}
