/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.facade;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.notification.NotificationService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.CitaService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ClienteService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.FacturaService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ServicioService;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author BICHO
 */
@Service
public class SystemFacade {
    private final ClienteService clienteService;
    private final ServicioService servicioService;
    private final CitaService citaService;
    private final FacturaService facturaService;

    public SystemFacade(ClienteService clienteService, ServicioService servicioService, CitaService citaService, FacturaService facturaService) {
        this.clienteService = clienteService;
        this.servicioService = servicioService;
        this.citaService = citaService;
        this.facturaService = facturaService;
    }
    
    public String crearCitaConFactura(Cliente cliente, Servicio servicio, LocalDate fecha, LocalTime hora) {
       //Asegurar existencia de entidades
        clienteService.registrarCliente(cliente);
        servicioService.registrarServicio(servicio);
        
        //Se crea la cita
        Cita cita = new Cita(fecha, hora, "Vigente");
        String resCita = citaService.registrarCita(cita);
        if (!resCita.toLowerCase().contains("exito")) return resCita;
        
        //Emitir una factura
        Factura factura = new Factura(fecha, servicio.getPrecio(), cita);
        factura.setCita(cita);
        String resFact = facturaService.registrarFactura(factura);
        if (!resFact.toLowerCase().contains("exito")) return resFact;
        
        //NOtificacion
        NotificationService.getInstance().notify(
            "cita.creada",
            "cita y factura creadas para " + cliente.getNombre()
        );
        return "Cita con factura creada correctamente";
    }
}
