package com.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.login")
@SpringBootApplication
public class SpringLoginApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringLoginApplication.class, args);
	}
}
