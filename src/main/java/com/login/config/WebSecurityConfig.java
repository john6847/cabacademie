package com.login.config;

import com.login.auth.filter.CsrfGrantingFilter;
import com.login.auth.matcher.NoAntPathRequestMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

import javax.servlet.Filter;
import javax.sql.DataSource;

import static com.login.auth.filter.CsrfGrantingFilter.X_XSRF_TOKEN;


@EnableWebSecurity
@Configuration
@Configurable
@EnableSpringHttpSession
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(7);
  }
//  @Autowired
//  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth)throws Exception{
    auth.jdbcAuthentication()
            .usersByUsernameQuery("select u.username, u.password, u.enabled from local_user u where u.username=?")
            .authoritiesByUsernameQuery("SELECT c.role.role FROM LocalUser AS c WHERE c.username =?")
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    String[] patterns = new String[] {
        "/",
        "/login",
        "/app/**/*",
        "/index.ftl",
        "/home.ftl",
        "/login.ftl",
        "/favicon.ico"
    };

    http
        .authorizeRequests()
        .antMatchers(patterns)
        .permitAll()
        .antMatchers("/api/user/**")
        .hasRole("USER")
        .and()
        .csrf()
        .disable()
        .httpBasic()
        .and()
        .addFilterAfter(csrfFilter(patterns), FilterSecurityInterceptor.class)
        .addFilterAfter(new CsrfGrantingFilter(), CsrfFilter.class);
  }

  private Filter csrfFilter(String[] patterns) {
    CsrfFilter csrfFilter = new CsrfFilter(csrfTokenRepository());
    csrfFilter.setRequireCsrfProtectionMatcher(csrfProtectionMatcher(patterns));
    return csrfFilter;
  }

  private NoAntPathRequestMatcher csrfProtectionMatcher(String[] patterns) {
    return new NoAntPathRequestMatcher(patterns);
  }

  private CsrfTokenRepository csrfTokenRepository() {
    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    repository.setHeaderName(X_XSRF_TOKEN);
    return repository;
  }

//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//        .inMemoryAuthentication()
//        .withUser("user").password("password").roles("USER");
//  }

  @Bean
  public SessionRepository sessionRepository() {
    return new MapSessionRepository();
  }

  @Bean
  public HeaderHttpSessionStrategy sessionStrategy() {
    return new HeaderHttpSessionStrategy();
  }
}
