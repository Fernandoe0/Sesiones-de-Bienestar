/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Usuario;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class ValidadorUsuario {
        public boolean usuarioNoNulo(Usuario u) {
        return u != null;
    }

    public boolean usernameValido(String username) {
        return username != null && !username.trim().isEmpty();
    }

    public boolean passwordValido(String password) {
        return password != null && !password.trim().isEmpty();
    }

    public boolean rolValido(String rol) {
        return rol != null && (rol.equalsIgnoreCase("administrador") || rol.equalsIgnoreCase("recepcionista"));
    }

    // Verificar unicidad de username
    public boolean usernameUnico(String username, List<Usuario> usuarios) {
        return usuarios.stream().noneMatch(u -> u.getUsername().equalsIgnoreCase(username));
    }
}
