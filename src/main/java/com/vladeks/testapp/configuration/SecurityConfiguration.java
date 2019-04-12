package com.vladeks.testapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        User.UserBuilder builder = User.withDefaultPasswordEncoder();

        UserDetails admin = builder
                .username("admin")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();
        UserDetails user = builder
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/question").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/question/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/question/**").hasRole("ADMIN")
                .and().csrf().disable();
    }
}
