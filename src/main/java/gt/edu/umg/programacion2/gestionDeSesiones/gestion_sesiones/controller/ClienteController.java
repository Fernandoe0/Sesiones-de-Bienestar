/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.ClienteService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }
    
    @PostMapping
    public String registrar(@RequestBody Cliente c) {
        return service.registrarCliente(c);
    }
    
    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }
    
    @GetMapping("/{idCliente}")
    public Cliente buscarPorId(@PathVariable Long idCliente) {
        return service.buscarPorId(idCliente);
    }
    
    @DeleteMapping("/{idCliente}")
    public String eliminar(@PathVariable Long idCliente) {
        return service.eliminar(idCliente);
    }
}
