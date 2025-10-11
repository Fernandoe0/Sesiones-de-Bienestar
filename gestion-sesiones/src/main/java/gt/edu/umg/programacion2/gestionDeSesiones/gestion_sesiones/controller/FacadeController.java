/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.facade.SystemFacade;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.CitaService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ClienteService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.FacturaService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ServicioService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/facade")
public class FacadeController {
    private final SystemFacade facade;

    public FacadeController(ClienteService cs, ServicioService ss, CitaService cis, FacturaService fs) {
        this.facade = new SystemFacade(cs, ss, cis, fs);
    }
    
@PostMapping("/cita-factura")
public Map<String,String> crear(@RequestBody Map<String,String> body) {
    Long idCliente = Long.valueOf(body.get("idCliente"));
    Long idServicio = Long.valueOf(body.get("idServicio"));
    LocalDate fecha = LocalDate.parse(body.get("fecha"));
    LocalTime hora = LocalTime.parse(body.get("hora"));
    
    Cliente cliente = new Cliente(idCliente);
    Servicio servicio = new Servicio(idServicio);
    
    String msg = facade.crearCitaConFactura(cliente, servicio, fecha, hora);
    return Map.of("resultado", msg);
}
}
