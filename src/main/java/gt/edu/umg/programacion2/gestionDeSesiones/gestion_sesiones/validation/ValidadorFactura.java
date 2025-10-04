/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class ValidadorFactura {
    public boolean facturaNoNula(Factura f) {
        return f != null;
    }
    
    public boolean fechaValida(String fechaEmision) {
        return fechaEmision != null && !fechaEmision.trim().isEmpty();
    }
    
    public boolean montoValido(double monto) {
        return monto > 0;
    }
    
    public boolean idUnico(int idFactura, List<Factura> facturas) {
        return facturas.stream().noneMatch(f -> f.getIdFactura() == idFactura);
    }
}
