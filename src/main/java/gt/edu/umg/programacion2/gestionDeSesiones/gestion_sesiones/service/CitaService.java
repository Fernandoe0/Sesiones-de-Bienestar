/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.Repositorio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorCita;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class CitaService {
     private final Repositorio<Cita> repo;
    private final ValidadorCita val;

    public CitaService(Repositorio<Cita> repo, ValidadorCita val) {
        this.repo = repo;
        this.val = val;
    }
    
    public String registrarCita(Cita nueva) {
        if (!val.ClienteValido(nueva.getCliente())){ return "Error: cliente inválido";}
        if (!val.ServicioValido(nueva.getServicio())){ return "Error: servicio inválido";}
        if (!val.citaUnica(nueva, repo.listar())) { return "Error: ya hay cita asignada";}
        repo.agregar(nueva);
        return "Cita registrada";
    }
    
    public List<Cita> listar() { return repo.listar();}
    
    public Cita buscarPorId(int idCita) {
        return repo.listar().stream()
                .filter(e -> e.getIdCita() == idCita)
                .findFirst()
                .orElse(null);
    }
    
    public boolean eliminar(int idCita) {
        Cita e = buscarPorId(idCita);
        if (e != null) {
            repo.eliminar(idCita);
            return true;
        }
        return false;
    }
}
