package io.longtu.cloud_music.config;

import io.longtu.cloud_music.filter.JwtAuthenticationFilter;
import io.longtu.cloud_music.filter.JwtAuthorizationFilter;
import io.longtu.cloud_music.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String SECRET_KEY = "tu ling music";

    public static final long EXPIRATION_TIME = 10 * 24 * 3600 * 1000;

    public static final String TOKEN_PREFIX = "token__";

    public static final String HEADER_STRING = "Authorization";

    public static final String SIGN_UP_URL = "/users/*";

    IUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(SIGN_UP_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
