/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Usuario;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.Repositorio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorUsuario;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class UsuarioService {
    private final Repositorio<Usuario> repo;
    private final ValidadorUsuario val;

    public UsuarioService(Repositorio<Usuario> repo, ValidadorUsuario val) {
        this.repo = repo;
        this.val = val;
    }
    
    public String RegistrarUsuario(Usuario u) {
        if (!val.usuarioNoNulo(u)) return "Error: Usuario no válido";
        if (!val.usernameValido(u.getUsername())) return "Error: Username inválido";
        if (!val.rolValido(u.getRol())) return "Error: rol inválido";
        if (!val.usernameUnico(u.getUsername(), repo.listar())) return "Error: username duplicado";
    
    repo.agregar(u);
    return "Usuario registrado exitosamente";
    }
    
 public List<Usuario> listar(){
     return repo.listar();
 }
 
 public Usuario buscarPorId(int idUsuario) {
     return repo.listar().stream()
             .filter(u -> u.getIdUsuario() == idUsuario)
             .findFirst()
             .orElse(null);
 }
 
 public boolean eliminar(int idUsuario) {
     Usuario usuario = buscarPorId(idUsuario);
     if (usuario != null) {
         repo.eliminar(usuario.getIdUsuario());
         return true;
     }
     return false;
 }
}
