package com.login;

import com.login.config.ApplicationSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.login")
@SpringBootApplication
public class SpringLoginApplication {

	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
		return new ApplicationSecurity();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringLoginApplication.class, args);
	}
}
