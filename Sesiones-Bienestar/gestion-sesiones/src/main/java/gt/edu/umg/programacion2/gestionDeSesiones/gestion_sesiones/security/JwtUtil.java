package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JwtUtil {

    private final Key key;
    private final long expirationMs;

    public JwtUtil(String secret, long expirationMs) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.expirationMs = expirationMs;
    }

    // Método para generar el token JWT con roles
    public String generateToken(String username, List<String> roles) {
        long now = System.currentTimeMillis();

        // Pasar roles como un claim
        Map<String, Object> claims = Map.of("roles", roles);

        return Jwts.builder()
                .setClaims(claims)  // Incluir roles en los claims
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Método para obtener el nombre de usuario del token
    public String getUsername(String token) {
        return parse(token).getBody().getSubject();
    }

    // Método para verificar si el token es válido
    public boolean isTokenValid(String token) {
        try {
            parse(token);  // Intenta parsear el token
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Parsear el token
    Jws<Claims> parse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
