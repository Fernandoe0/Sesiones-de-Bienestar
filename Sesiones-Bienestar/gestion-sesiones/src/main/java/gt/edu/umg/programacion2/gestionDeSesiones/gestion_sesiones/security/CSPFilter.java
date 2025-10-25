/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;


import jakarta.servlet.Filter;  // Asegúrate de que se use jakarta.servlet.Filter
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/**")  // Aplica a todas las rutas
public class CSPFilter implements Filter {

    // Este método se llama cuando se inicializa el filtro
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Puedes dejarlo vacío si no necesitas alguna inicialización especial
    }

    // Este es el método que procesa las solicitudes y respuestas
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Configura la política CSP
        response.setHeader("Content-Security-Policy", "default-src 'self'; connect-src 'self' http://localhost:8080;");

        // Continuar con la cadena de filtros
        chain.doFilter(request, response);
    }

    // Este método se llama cuando se destruye el filtro
    @Override
    public void destroy() {
        // Puedes dejarlo vacío si no necesitas limpiar recursos
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
