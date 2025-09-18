/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Usuario;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.CitaRepositorioEnMemoria;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.ClienteRepositorioEnMemoria;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.FacturaRepositorioEnMemoria;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.ServicioRepositorioEnMemoria;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.UsuarioRepositorioEnMemoria;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.CitaService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ClienteService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.FacturaService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ServicioService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.UsuarioService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorCita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorCliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorFactura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorServicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorUsuario;

/**
 *
 * @author BICHO
 */
public class MainDemo {
   public static void main(String[] args) {
       ClienteRepositorioEnMemoria repo = new ClienteRepositorioEnMemoria();
       ValidadorCliente val = new ValidadorCliente();
       ClienteService service = new ClienteService(repo, val);
      
        //Creación de Clientes 
       Cliente c1 = new Cliente(0, "Luis Fernando", "fernandoe01@gmail.com", "3324-4488");
       System.out.println(service.registrarCliente(c1));
       
       Cliente c2 = new Cliente(0, "Juan Jose", "fernandoe01@gmail.com", "4225-3325");
       System.out.println(service.registrarCliente(c2));
       
       //Servicios 
       ServicioRepositorioEnMemoria servicioRepo = new ServicioRepositorioEnMemoria();
       ValidadorServicio valServicio = new ValidadorServicio();
       ServicioService servicioService = new ServicioService(servicioRepo, valServicio);
           
       Servicio servicio1 = new Servicio(1, "Masaje", "Masaje relajante", 150.00);
       
       System.out.println(servicioService.registrarServicio(servicio1));
   
       //Citas
       CitaRepositorioEnMemoria repo2 = new CitaRepositorioEnMemoria();
       ValidadorCita valCita = new ValidadorCita();
       CitaService citaService = new CitaService(repo2, valCita);
       
      
       Cita cita1 = new Cita(0, "12/12/2024", "11:45", "Vigente", c1, servicio1);
       System.out.println(citaService.registrarCita(cita1));
       
      
       // Factura
       FacturaRepositorioEnMemoria facturaRepo = new FacturaRepositorioEnMemoria();
       ValidadorFactura valFactura = new ValidadorFactura();
       FacturaService facturaService = new FacturaService(facturaRepo, valFactura);
       
       Factura fact1 = new Factura(1, "17/09/2025", servicio1.getPrecio());
       System.out.println(facturaService.registrarFactura(fact1));
       
       // Usuario
       UsuarioRepositorioEnMemoria usuarioRepo = new UsuarioRepositorioEnMemoria();
       ValidadorUsuario valUsuario = new ValidadorUsuario();
       UsuarioService usuarioService = new UsuarioService(usuarioRepo, valUsuario);
       
       Usuario u1 = new Usuario(1, "admin", "0000", "administrador");
       System.out.println(usuarioService.RegistrarUsuario(u1));

       //Listas
       System.out.println("\n==Clientes==");
       service.listar().forEach(c -> System.out.println(c.getIdCliente()+ " - " + c.getNombre()));
       
       System.out.println("\n==Servicios==");
       servicioService.listar().forEach(c -> System.out.println(c.getIdServicio()+ " - " + c.getNombre()));
       
       System.out.println("\n==Citas==");
       citaService.listar().forEach(e -> System.out.println(e.getIdCita() + " - " + e.getCliente().getNombre() + " - " + e.getServicio().getNombre()));
       
       System.out.println("\n==Facturas==");
       facturaService.listar().forEach(f -> System.out.println("Factura: " + f.getIdFactura() + ": " + f.getMonto() + " - " + f.getFechaEmision()));
       
       System.out.println("\n==Usuarios==");
       usuarioService.listar().forEach(u -> System.out.println(u.getUsername() + "(" + u.getRol() + ")"));
       
   }
}
