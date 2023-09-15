package com.example.demo.config;

import com.example.demo.enums.UserRole;
import com.example.demo.handler.WebAccessDeniedHandler;
import com.example.demo.handler.WebAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    // 스프링 시큐리티에 대한 설정을 이곳에서 관리
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.authorizeHttpRequests((request) -> request.requestMatchers(new AntPathRequestMatcher("/comments/*")).hasAuthority("ROLE_ADMIN"))
                .authorizeHttpRequests((request) -> request
                        .requestMatchers(new AntPathRequestMatcher("/comment/*")).hasAuthority(UserRole.ADMIN.getValue())
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/**")))
                .formLogin((formLogin) -> formLogin/*로그인 url 설정*/
                        .loginPage("/users/login")
                        .usernameParameter("userId")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/"))

                .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true))
                .exceptionHandling((ex) -> ex.accessDeniedHandler(accessDeniedHandler()))
                .exceptionHandling((ex) -> ex.authenticationEntryPoint(authenticationEntryPoint()))

        ;

        return http.build();
    }

    @Bean
    AccessDeniedHandler accessDeniedHandler() {
        return new WebAccessDeniedHandler();
    }

    AuthenticationEntryPoint authenticationEntryPoint() {
        return new WebAuthenticationEntryPoint();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
