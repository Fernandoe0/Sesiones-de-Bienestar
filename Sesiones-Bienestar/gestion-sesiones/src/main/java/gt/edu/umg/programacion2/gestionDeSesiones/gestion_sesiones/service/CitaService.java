/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.audit.Auditable;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.notification.NotificationService;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.CitaRepository;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
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
    
   @Auditable("Registrar Cita")
public String registrarCita(Cita nueva) {
    if(nueva == null) return "Error: Cita inválida";
    if(nueva.getFecha() == null) return "Error: ingrese fecha";
    if(nueva.getHora() == null) return "Error: ingrese Hora";
    Cita creada = repo.save(nueva);
    String nombreCliente = (creada.getCliente() != null && creada.getCliente().getNombre() != null)
            ? creada.getCliente().getNombre()
            : "N/D";
    NotificationService.getInstance().notify("cita.creada",
        "Cita " + creada.getIdCita() + " para " + creada.getCliente().getNombre());
    return "Registro exitoso de cita id=" + creada.getIdCita();
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
