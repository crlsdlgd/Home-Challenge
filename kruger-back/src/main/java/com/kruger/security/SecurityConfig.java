package com.kruger.security;

import java.util.List;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//@Configuration
//public class SecurityConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/", "/login", "/index.html").permitAll()
//				.anyRequest().authenticated())
//				.oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("http://localhost:4200/dashboard", true))
//				.exceptionHandling(
//						exception -> exception.authenticationEntryPoint((request, response, authException) -> {
//							response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//							response.getWriter().write("Unauthorized access - please login.");
//						}))
//				.cors();
//
//		return http.build();
//	}
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:4200/client")); // Permitir el origen de tu frontend
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); // Métodos permitidos
        config.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        config.setAllowCredentials(true); // Permitir cookies y credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplica la configuración a todas las rutas
        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
        		authorize -> authorize.requestMatchers("/", "/login","/api/v1/user/update").permitAll()
                .anyRequest().authenticated()) 
                .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("http://localhost:4200/dashboard", true)) // Redirige después del login exitoso
                .exceptionHandling(exception -> exception.authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Unauthorized access - please login.");
                }))
                .oauth2Login(Customizer.withDefaults())
                .csrf().disable()
                .cors(); // Habilita el soporte de CORS
        return http.build();
    }
}
