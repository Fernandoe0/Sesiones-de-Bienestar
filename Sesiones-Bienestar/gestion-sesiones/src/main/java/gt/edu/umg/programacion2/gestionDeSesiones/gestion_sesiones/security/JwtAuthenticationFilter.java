package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@WebFilter(urlPatterns = "/**")  // Filtro para todas las rutas
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

    String token = extractToken(request);  // Aquí extraes el token del header
    if (token != null && jwtUtil.isTokenValid(token)) {
        String username = jwtUtil.getUsername(token); // Aquí obtienes el username
        List<String> roles = (List<String>) jwtUtil.parse(token).getBody().get("roles"); // Extraes los roles del token

        // Convertir los roles a SimpleGrantedAuthority, como Spring Security requiere
        List<SimpleGrantedAuthority> authorities = roles.stream()
            .map(role -> new SimpleGrantedAuthority(role))
            .collect(Collectors.toList());

        // Crear el token de autenticación con el username y los roles
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
        // Establecer la autenticación en el contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authenticationToken); // Esto debería autenticar correctamente
    }

    filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);  // Elimina el "Bearer " del token
        }
        return null;
    }
}
