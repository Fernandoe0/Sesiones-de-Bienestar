/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author BICHO
 */
@Configuration
public class SecurityConfig {
    @Value("${jwt.secret}") private String jwtSecret;
    @Value("${jwt.expiration}") private long jwtExpiration;
    
    @Bean public JwtUtil jwtUtil() { return new JwtUtil(jwtSecret, jwtExpiration); }
    @Bean public JwtAuthenticationFilter jwtAuthFilter() { return new JwtAuthenticationFilter(jwtUtil()); }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**", "/h2-console/**").permitAll()
                .anyRequest().authenticated())
              .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);
        
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }
    
}
