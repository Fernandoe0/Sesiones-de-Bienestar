/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BICHO
 */
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    boolean existsByNombre(String nombre);
}
