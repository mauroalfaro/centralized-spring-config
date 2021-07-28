package com.alfarosoft.centralizedconfig.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurity.class);
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.debug("Using custom configuration (HttpSecurity).");
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/health","/api/version","/actuator/health","/actuator/info","/actuator/**").anonymous()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
        ;
    }
}
