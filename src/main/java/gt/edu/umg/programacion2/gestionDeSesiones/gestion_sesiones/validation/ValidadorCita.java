/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class ValidadorCita {
    public boolean ClienteValido(Cliente cliente) {
        return cliente != null;
    }
    
    public boolean ServicioValido(Servicio servicio) {
        return servicio != null;
    }
    
    public boolean citaUnica (Cita nueva, List<Cita> citas) {
            return citas.stream().noneMatch(d -> 
                    nueva.getFecha().equals(nueva.getFecha()) &&
                    nueva.getHora().equals(nueva.getHora()));
    }
    
}
