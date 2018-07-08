package com.login.config;


import com.login.config.cors.CORSFilter;
import com.login.config.rest.RESTAuthenticationEntryPoint;
import com.login.config.rest.RESTAuthenticationSuccessHandler;
import com.login.config.rest.RESTLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class SecurityConfiguration {

	@Bean
	public RESTAuthenticationEntryPoint authenticationEntryPoint() {
		return new RESTAuthenticationEntryPoint();
	}

	@Bean
	public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler();
	}

	@Bean
	public RESTAuthenticationSuccessHandler authenticationSuccessHandler() {
		return new RESTAuthenticationSuccessHandler();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(7);
	}

	@Bean
	public CORSFilter corsFilter() {
		return new CORSFilter();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new RESTLogoutSuccessHandler();
	}
}
