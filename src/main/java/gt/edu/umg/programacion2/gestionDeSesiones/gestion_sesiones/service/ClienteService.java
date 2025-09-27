/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author BICHO
 */
@Service
public class ClienteService {
    private final ClienteRepository repo;


    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }
    
    public String registrarCliente(Cliente c) {
        if (repo.existsByCorreo(c.getCorreo())) {
            return "Error: correo duplicado";
        }
        repo.save(c);
        return "Cliente registrado en BD";
    }
    
    public List<Cliente> listar() {
        return repo.findAll();
    }
    
    public Cliente buscarPorId(Long idCliente) {
        Optional<Cliente> optionalCliente = repo.findById(idCliente);
        return optionalCliente.orElse(null);
    }
    
    public String eliminar(Long idCliente) {
        if (!repo.existsById(idCliente)){
            return "Error: Cliente no encontrado";
        }
        repo.deleteById(idCliente);
        return "Cliente eliminado correctamente";
    }
 }
