/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.FacturaService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/facturas")
public class FacturaController {
    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }
    
    @PostMapping
    public String registrar(@RequestBody Factura f) {
        return service.registrarFactura(f);
    }
    
    @GetMapping
    public List<Factura> listar() {
        return service.listar();
    }
    
    @GetMapping("/{idFactura}")
    public Factura buscarPorId(@PathVariable Long idFactura) {
        return service.buscarPorId(idFactura);
    }
    
    @DeleteMapping("/{idFactura}")
    public String eliminar(@PathVariable Long idFactura) {
        return service.eliminar(idFactura);
    }
    
}
