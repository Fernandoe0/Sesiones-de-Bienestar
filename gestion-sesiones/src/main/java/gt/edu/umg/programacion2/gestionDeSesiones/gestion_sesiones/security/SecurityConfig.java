/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;


import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author BICHO
 */
@Configuration
public class SecurityConfig {
    @Value("${jwt.secret}") private String jwtSecret;
    @Value("${jwt.expiration}") private long jwtExpiration;
    
    @Bean public JwtUtil jwtUtil() { return new JwtUtil(jwtSecret, jwtExpiration); }
    @Bean public JwtAuthenticationFilter jwtAuthFilter(JwtUtil jwtUtil) { return new JwtAuthenticationFilter(jwtUtil); }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.setAllowedOrigins(List.of("http://localhost:5137", "http://localhost:3000"));
        cfg.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        cfg.setAllowedHeaders(List.of("*"));
        cfg.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthFilter)  throws Exception {
        http
           .csrf(csrf -> csrf.disable())
           .cors(cors -> {})
           .authorizeHttpRequests(auth -> auth
           .requestMatchers("/auth/**", "/h2-console/**").permitAll()
           .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
           .anyRequest().authenticated()
           )
           .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
           .headers(headers -> headers.frameOptions(frame -> frame.disable()));
        
        return http.build();
    }
    
}
