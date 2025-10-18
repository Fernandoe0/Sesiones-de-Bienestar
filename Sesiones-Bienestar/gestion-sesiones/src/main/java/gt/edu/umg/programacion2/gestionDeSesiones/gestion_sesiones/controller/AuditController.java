/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.audit.AuditLog;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.audit.AuditLogRepository;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/audit")
public class AuditController {
    private final AuditLogRepository repo;

    public AuditController(AuditLogRepository repo) {
        this.repo = repo;
    }
    @GetMapping("/logs")
    public List<AuditLog> logs() { return repo.findAll();}
}
