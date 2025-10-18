/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.controller;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Usuario;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service.UsuarioService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author BICHO
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    
    @PostMapping
    public String registrar(@RequestBody Usuario u) {
        return service.RegistrarUsuario(u);
    }
    
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }
    
    @GetMapping("/{idUsuario}")
    public Usuario buscarPorId(@PathVariable Long idUsuario) {
        return service.buscarPorId(idUsuario);
    }
    
    @DeleteMapping("/{idUsuario}")
    public String eliminar(@PathVariable Long idUsuario) {
        return service.eliminar(idUsuario);
    }
}
