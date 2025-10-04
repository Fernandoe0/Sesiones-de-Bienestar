/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.ServicioRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author BICHO
 */
@Service
public class ServicioService {
    private final ServicioRepository repo;



    public ServicioService(ServicioRepository repo) {
        this.repo = repo;
    }
    
    
    public String registrarServicio(Servicio s) {
    

    if (s == null) return "Error: Servicio nulo";
    if (s.getNombre() == null || s.getNombre().trim().isEmpty()) 
        return "Error: nombre inválido";
    if (s.getPrecio() == null || s.getPrecio().compareTo(BigDecimal.ZERO) <= 0)
        return "Error: precio inválido";
   
    repo.save(s);
    return "Servicio registrado exitosamente";
    }
    
    public List<Servicio> listar() {
        return repo.findAll();
    }
   
    public Servicio buscarPorId(Long idServicio) {
        return repo.findById(idServicio).orElse(null);
    }
    
    public String eliminar(Long idServicio) {
        if (!repo.existsById(idServicio)) {
            return "Error: servicio no encontrado";
        }
            repo.deleteById(idServicio);
            return "Servicio eliminado correctamente";
    }
}
