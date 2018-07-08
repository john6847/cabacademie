package com.login.config;

import com.login.config.cors.CORSFilter;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Dany on 03/06/2018.
 */
@SuppressWarnings("ALL")
@Configuration
@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    public static final String LOGIN = "/login";
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private CORSFilter corsFilter;
    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(7);
    }

    @Autowired
    private DataSource dataSource;


    @Autowired
    Environment environment;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select u.username, u.password, u.enabled from local_user u where u.username=?")
                .authoritiesByUsernameQuery("select r.username, r.role from role r where r.username=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/*/**").permitAll()
                .antMatchers("/login", "/rest/open/**").permitAll()
                .antMatchers("/logout", "/rest/**").authenticated()
                .and().csrf().disable();

        // Handlers and entry points
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler);

        // Logout
        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);

        // CORS
        http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);

    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }


    class AjaxAwareEntryPoint extends LoginUrlAuthenticationEntryPoint {

        private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
        private static final String X_REQUESTED_WITH = "X-Requested-With";

        public AjaxAwareEntryPoint(String loginFormUrl) {
            super(loginFormUrl);
        }

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                throws IOException, ServletException {
            if (XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH))) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                super.commence(request, response, exception);
            }
        }

//class CsrfHeaderFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//        if (csrf != null) {
//            Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//            String token = csrf.getToken();
//            if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
//                cookie = new Cookie("XSRF-TOKEN", token);
//                cookie.setPath("/");
//                response.addCookie(cookie);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}

    }
}