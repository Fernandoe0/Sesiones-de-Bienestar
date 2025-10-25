/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;

/**
 *
 * @author BICHO
 */

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter> loggingFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CSPFilter());  // Instancia del filtro CSP
        registrationBean.addUrlPatterns("/**");  // Aplica a todas las rutas
        return registrationBean;
    }
}