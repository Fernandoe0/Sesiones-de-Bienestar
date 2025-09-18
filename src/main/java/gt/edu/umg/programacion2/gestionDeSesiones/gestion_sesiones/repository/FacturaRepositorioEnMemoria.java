/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Factura;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.util.IdGenerator;
import java.util.*;

/**
 *
 * @author BICHO
 */
public class FacturaRepositorioEnMemoria implements Repositorio<Factura> {
    private final Map<Integer, Factura> data = new HashMap<>();
    private final IdGenerator idGen = new IdGenerator();
    
    @Override
    public void agregar(Factura entidad) {
        int idFactura = idGen.next();
        entidad.setIdFactura(idFactura);
        data.put(idFactura, entidad);
    }

    @Override
    public List<Factura> listar() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Factura buscarPorId(int idFactura) {
        return data.get(idFactura);
    }

    @Override
    public void actualizar(Factura entidad) {
        if (data.containsKey(entidad.getIdFactura())) {
            data.put(entidad.getIdFactura(), entidad);
        }
    }

    @Override
    public void eliminar(int idFactura) {
        data.remove(idFactura);
    }
    
}
