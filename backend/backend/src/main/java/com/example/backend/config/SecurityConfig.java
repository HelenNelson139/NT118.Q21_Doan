package com.example.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${jwt.sigerKey}")
    private String secrect;

    private final String[] PUBLIC_ENDPOINTS = { "/api/users"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //gọi đối tượng xử lý HttpSecurity là httpSecurity
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests ->
                requests
                       .requestMatchers(HttpMethod.POST, "/api/teachers/register" ).permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/students/register" ).permitAll()
                        .anyRequest().authenticated());
        httpSecurity.oauth2ResourceServer(oauth2 ->
                oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder()))
        );
        System.out.println("Security Config Loaded!");
        return httpSecurity.build();
    }
//
    @Bean
    JwtDecoder jwtDecoder(){
        SecretKeySpec secretKeySpec = new SecretKeySpec("secret".getBytes(), "HS512");
       return NimbusJwtDecoder
               .withSecretKey(secretKeySpec)
               .macAlgorithm(MacAlgorithm.HS512)
               .build();

    }


}
