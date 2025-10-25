package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String username;

    public JwtAuthenticationToken(String username) {
        super(new ArrayList<>());
        this.username = username;
        setAuthenticated(true);  // El token es válido, por lo que se puede marcar como autenticado
    }

    @Override
    public Object getCredentials() {
        return null;  // El JWT no requiere credenciales en este contexto
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }
    
}
