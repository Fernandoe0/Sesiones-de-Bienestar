/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Usuario;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.security.JwtUtil;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.UsuarioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }
    
    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> body) {
        String username = body.get("username");
        String password = body.get("password");
        Usuario u = usuarioService.login(username, password);
        if (u == null) throw new RuntimeException("Credenciales inválidas");
        
        Map<String,Object> claims = new HashMap<>();
        claims.put("role", u.getRol());
        String token = jwtUtil.generateToken(u.getUsername(), claims);
        return Map.of("token", token);
    }
    
    
}
