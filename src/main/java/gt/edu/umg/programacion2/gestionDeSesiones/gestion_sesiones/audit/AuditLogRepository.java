/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.audit;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BICHO
 */
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    
}
