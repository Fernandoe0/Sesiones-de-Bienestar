/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.Repositorio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorCliente;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class ClienteService {
    private final Repositorio<Cliente> repo;
    private final ValidadorCliente val;

    public ClienteService(Repositorio<Cliente> repo, ValidadorCliente val) {
        this.repo = repo;
        this.val = val;
    }
    
    public String registrarCliente(Cliente c) {
        if (!val.correoValido(c.getCorreo())) return "Error: correo inválido";
        if (!val.correoUnico(c.getCorreo(), repo.listar())) return "Error: correo duplicado";
        repo.agregar(c);
        return "Cliente registrado";
    }
    
    public List<Cliente> listar() { return repo.listar();}
    
    public Cliente buscarPorId(int idCliente) {
        return repo.listar().stream()
                .filter(c ->c.getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);
    }
    
    public boolean eliminar(int idCliente) {
        Cliente c = buscarPorId(idCliente);
        if (c != null) {
            repo.eliminar(idCliente);
            return true;
        }
        return false;
    }
 }
