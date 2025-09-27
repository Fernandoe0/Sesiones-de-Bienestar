/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ServicioService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/servicios")
public class ServicioController {
    private final ServicioService service;

    public ServicioController(ServicioService service) {
        this.service = service;
    }
    
    @PostMapping
    public String registar(@RequestBody Servicio s) {
        return service.registrarServicio(s);
    }
    
    @GetMapping 
    public List<Servicio> listar() {
        return service.listar();
    }
    
    @GetMapping("/{idServicio}")
    public Servicio buscarPorId(@PathVariable Long idServicio) {
        return service.buscarPorId(idServicio);
    }
    
    @DeleteMapping("/{idServicio}")
    public String eliminar(@PathVariable Long idServicio) {
        return service.eliminar(idServicio);
    }
    
}
