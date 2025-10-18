/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private final Key key;
    private final long expirationMs;

    public JwtUtil(String secret, long expirationMs) {
        // Asegurar una clave de al menos 32 bytes para HS256
        byte[] keyBytes = deriveAtLeast32Bytes(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.expirationMs = expirationMs;
    }

    public String generateToken(String username, Map<String, Object> claims) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return parse(token).getBody().getSubject();
    }

    // ================== helpers ==================
    private Jws<Claims> parse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    private static byte[] deriveAtLeast32Bytes(String secret) {
        // Si la cadena es suficientemente larga, usar bytes directos
        byte[] raw = secret == null ? new byte[0] : secret.getBytes(StandardCharsets.UTF_8);
        if (raw.length >= 32) return raw;

        // Si es corta, derivar 32 bytes con SHA-256 (determinístico)
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(raw);
        } catch (Exception e) {
            // Fallback improbable
            byte[] padded = new byte[32];
            System.arraycopy(raw, 0, padded, 0, Math.min(raw.length, 32));
            return padded;
        }
    }
}