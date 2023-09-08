package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((request)-> request
                        .requestMatchers(new AntPathRequestMatcher("/comment/*")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                )
                .csrf((csrf)-> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/**")))
                .formLogin((formLogin)-> formLogin
                        .defaultSuccessUrl("/"))
                .logout((logout)-> logout.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true))
// preauthorize 와 postauthoriz의 경우에 미리 권한이 없으면 탐색할수 , 검색? 의 경우에 적용하기 위해서가 아닐까?
        ;

        return http.build();
    }
}
