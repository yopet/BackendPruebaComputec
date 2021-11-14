package com.crud.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CrudPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPruebaApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                		.allowedOrigins("*")
                		.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")
                		.allowedHeaders("*");
            }
        };
    }
	


	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	                @Override
	                public void addCorsMappings(CorsRegistry registry) {
	                        registry.addMapping("/api/**")
	                                .allowedOrigins("http://localhost:8080")
	                                .allowedMethods("GET", "POST","PUT", "DELETE","OPTIONS")
	                                .maxAge(3600);
	                }

	        };
	}*/
	
	

}
