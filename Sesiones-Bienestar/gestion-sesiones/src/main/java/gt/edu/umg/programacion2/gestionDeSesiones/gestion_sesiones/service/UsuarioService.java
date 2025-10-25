/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Usuario;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.Repositorio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.UsuarioRepository;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorUsuario;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author BICHO
 */
@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }
    
    public String RegistrarUsuario(Usuario u) {
        if (u == null) return "Error usuario inválido";
        if (u.getUsername() == null || u.getUsername().trim().isEmpty())
            return "Error: Username Inválido";
        if(u.getRol() == null || u.getRol().trim().isEmpty())
            return "Error: rol inválido";
        if (repo.existsByUsername(u.getUsername()))
            return "Error: Username duplicado";
        
    repo.save(u);
    return "Usuario registrado exitosamente";
    }
    
 public List<Usuario> listar(){
     return repo.findAll();
 }
 
 
 public Usuario buscarPorId(Long idUsuario) {
     return repo.findById(idUsuario).orElse(null);
 }
 
 public String eliminar(Long idUsuario) {
     if(!repo.existsById(idUsuario)) {
         return "Error: Usuario no encontrado";
     }
     repo.deleteById(idUsuario);
     return "Usuario eliminado correctamente";
 }
 
 public Usuario login(String username, String password) {
        Usuario usuario = repo.findByUsername(username).orElse(null);
        
        if (!BCrypt.checkpw(password, usuario.getPassword())) {
            return null;
        }
        return usuario;
}
 
 
  public String cifrarContrasena(String contrasena) {
        String salt = BCrypt.gensalt();

        return BCrypt.hashpw(contrasena, salt);
    }

    public boolean verificarContrasena(String contrasena, String contrasenaCifrada) {

        return BCrypt.checkpw(contrasena, contrasenaCifrada);
    }
    
    public void guardarUsuario(Usuario usuario) {
        String contrasenaCifrada = cifrarContrasena(usuario.getPassword());
        usuario.setPassword(contrasenaCifrada); }
}