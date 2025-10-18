/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.audit.Auditable;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.notification.NotificationService;
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
    
    @Auditable("Emitir Factura")
public String registrarFactura(Factura factura) {
    Factura emitida = repo.save(factura);
    NotificationService.getInstance().notify("factura.emitida",
        "Factura " + emitida.getIdFactura() + " por Q" + emitida.getMonto());
    return "Registro exitoso de factura id=" + emitida.getIdFactura();
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
