/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.CitaService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/citas")
public class CitaController {
    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }
    
    @PostMapping
    public String registrar(@RequestBody Cita nueva) {
        return service.registrarCita(nueva);
    }
    
    @GetMapping
    public List<Cita> listar() {
        return service.listar();
    }
    
    @GetMapping("/{idCita}")
    public Cita buscarPorId(@PathVariable Long idCita) {
        return service.buscarPorId(idCita);
    }
    
    @DeleteMapping("/{idCita}")
    public String eliminar(@PathVariable Long idCita) {
        return service.eliminar(idCita);
    }
}
