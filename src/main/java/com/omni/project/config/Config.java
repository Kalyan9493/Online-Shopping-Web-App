package com.omni.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.omni.project.serviceImpl.ProductServiceImpl;

@Configuration
@ComponentScan("com.example.demo")
public class Config {
	@Bean
	public ProductServiceImpl bean() {
		return new ProductServiceImpl();
	}

}
