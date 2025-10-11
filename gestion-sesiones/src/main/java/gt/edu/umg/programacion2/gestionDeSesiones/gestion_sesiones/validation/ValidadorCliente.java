/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class ValidadorCliente {
    
    public boolean correoValido(String correo) {
        return correo != null && correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    public boolean correoUnico ( String correo, List<Cliente> clientes) {
            return clientes.stream().noneMatch(c -> c.getCorreo().equalsIgnoreCase(correo));
    }
}
