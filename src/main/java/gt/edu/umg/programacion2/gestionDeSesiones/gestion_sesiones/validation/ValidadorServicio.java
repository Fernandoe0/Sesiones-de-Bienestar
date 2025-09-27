/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;

/**
 *
 * @author BICHO
 */
public class ValidadorServicio {
    
    public boolean ServicioValido(Servicio servicio) {
        return servicio != null;
    }
    
    public boolean nombreValido(String nombre) {
        return nombre!= null && !nombre.trim().isEmpty();
    }
    
    public boolean precioValido (double precio) {
        return precio > 0;
    }
}
