package com.login;

import com.login.service.UserService;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableAutoConfiguration(exclude = { WebMvcAutoConfiguration.class })
@ComponentScan(basePackages = "com.login")
@SpringBootApplication

public class SpringLoginApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext= SpringApplication.run(SpringLoginApplication.class, args);

		UserService userService = (UserService)appContext.getBean("userService");
		userService.crearAdmin();
	}
}
