package org.school.management.api.security;

import lombok.RequiredArgsConstructor;
import org.school.management.api.services.impl.AuthenticationUserDetailServiceImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationUserDetailServiceImpl authenticationDetailsService;

    private static final String[] SWAGGER = {
            "/v2/api-docs",
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/configuration/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/h2-console/**",
            "/users"
    };

    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                        //.antMatchers(HttpMethod.POST,"/users").permitAll().anyRequest().authenticated()
                        //.antMatchers("users/**","swagger-ui/**","v3/api-docs/**").permitAll().anyRequest().authenticated()
                .antMatchers(SWAGGER).permitAll()
                        .anyRequest().authenticated()
                        .and()
                        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
}