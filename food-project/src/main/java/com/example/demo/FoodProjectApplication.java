package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

@SpringBootApplication
public class FoodProjectApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");
		SpringApplication.run(FoodProjectApplication.class, args);
	}
	
	@Bean()
	public MultipartResolver multipartResolver()
	{
		return new org.springframework.web.multipart.commons.CommonsMultipartResolver();		
	}

}
