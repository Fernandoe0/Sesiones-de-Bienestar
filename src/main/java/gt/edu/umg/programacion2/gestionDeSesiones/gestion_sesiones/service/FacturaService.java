/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.FacturaRepository;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author BICHO
 */
@Service
public class FacturaService {
    private final FacturaRepository repo;

    public FacturaService(FacturaRepository repo) {
        this.repo = repo;
    }
    
    public String registrarFactura(Factura f) {
        if (f == null) return "Error: factura nula";
        if (f.getFechaEmision() == null) return "Error: fecha inválida";
        if (f.getMonto() == null || f.getMonto().doubleValue() <= 0)
            return "Error monto inválido";
        
        repo.save(f);
        return "Factura registrada exitosamente";
       
    }
    
    public List<Factura> listar(){
        return repo.findAll();
    }
    
    public Factura buscarPorId(Long idFactura) {
        return repo.findById(idFactura).orElse(null);
    }
    
    public String eliminar(Long idFactura) {
        if (!repo.existsById(idFactura)) {
            return "Error: Factura no encontrada";
        }
        repo.deleteById(idFactura);
        return "Factura eliminada correctamente";
    }
}
