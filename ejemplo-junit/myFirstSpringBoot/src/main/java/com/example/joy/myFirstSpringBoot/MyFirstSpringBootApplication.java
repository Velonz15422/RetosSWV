package com.example.joy.myFirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication(scanBasePackages = {"com.example.joy"})
public class MyFirstSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringBootApplication.class, args);
    }

    @Configuration
    public class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests().anyRequest().authenticated()
                    .and().oauth2ResourceServer().jwt();
        }
    }
}

