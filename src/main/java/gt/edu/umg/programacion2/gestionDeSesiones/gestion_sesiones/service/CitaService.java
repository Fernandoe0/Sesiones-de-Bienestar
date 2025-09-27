/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.CitaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author BICHO
 */
@Service
public class CitaService {
     private final CitaRepository repo;

    public CitaService(CitaRepository repo) {
        this.repo = repo;

    }
    
    public String registrarCita(Cita nueva) {
        if (nueva.getCliente() == null){
          return "Error: Cliente no especificado";      
        }
        List<Cita> citasExistentes = repo.findByClienteIdCliente(nueva.getCliente().getIdCliente());
        if(!citasExistentes.isEmpty()) {
            return "Error: Cliente ya con cita";
        }
        repo.save(nueva);
        return "Cita Registrada";
    }
    
    public List<Cita> listar() {
        return repo.findAll();
    }
    
    public Cita buscarPorId(Long idCita) {
        Optional<Cita> optionalCita = repo.findById(idCita);
        return optionalCita.orElse(null);
    }
    
    public String eliminar(Long idCita) {
        if (!repo.existsById(idCita)) {
            return "Error: Cita no encontrada";
        }
        repo.deleteById(idCita);
        return "Cita eliminada correctamente";
    }
}
