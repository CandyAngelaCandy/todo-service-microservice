package com.thoughtworks.training.huangyanyan.todoserice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurittyConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UnauthorizeEntryPoint unauthorizeEntryPoint;

    @Autowired
    private ToDoAuthFilter toDoAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //super.configure(http);
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login","/todos/**").permitAll()
                .antMatchers("/hystrix*/**","/webjars/**","/*.stream/**").permitAll()
                .antMatchers("/health").permitAll()
                .anyRequest().authenticated()
                .and().addFilterBefore(toDoAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(unauthorizeEntryPoint);
    }
}
