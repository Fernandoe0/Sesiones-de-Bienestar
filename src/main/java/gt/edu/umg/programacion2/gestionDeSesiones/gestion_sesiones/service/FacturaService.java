/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.Repositorio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorFactura;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class FacturaService {
    private final Repositorio<Factura> repo;
    private final ValidadorFactura val;

    public FacturaService(Repositorio<Factura> repo, ValidadorFactura val) {
        this.repo = repo;
        this.val = val;
    }
    
    public String registrarFactura(Factura f) {
        if (!val.facturaNoNula(f)) return "Error: factura nula";
        if (!val.fechaValida(f.getFechaEmision())) return "Error: fecha inválida";
        if (!val.montoValido(f.getMonto())) return "Error: monto inválido";
        if (!val.idUnico(f.getIdFactura(), repo.listar())) return "Error: Id duplicado";
        
        repo.agregar(f);
        return "Factura registrada exitosamente";
       
    }
    
    public List<Factura> listar(){
        return repo.listar();
    }
    
    public Factura buscarPorId(int idFactura) {
        return repo.listar().stream()
                .filter(f -> f.getIdFactura() == idFactura)
                .findFirst()
                .orElse(null);
    }
    
    public boolean eliminar(int idFactura) {
        Factura f = buscarPorId(idFactura);
        if (f != null) {
            repo.eliminar(idFactura);
            return true;
        }
        return false;
    }
}
