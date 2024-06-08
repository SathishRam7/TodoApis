package org.ram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("org.ram.mapper")
public class TodoApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApisApplication.class, args);
	}
	
	
	@Bean  
	   public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		  public void addCorsMappings(CorsRegistry registry) {
			 registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
		 }
		};
	}

}
