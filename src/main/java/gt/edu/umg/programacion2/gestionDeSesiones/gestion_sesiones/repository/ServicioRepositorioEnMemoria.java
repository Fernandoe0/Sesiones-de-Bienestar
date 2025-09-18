/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.util.IdGenerator;
import java.util.*;

/**
 *
 * @author BICHO
 */
public class ServicioRepositorioEnMemoria implements Repositorio<Servicio> {
    private final Map<Integer, Servicio> data = new HashMap<>();
    private final IdGenerator idGen = new IdGenerator();
    
    
    @Override
    public void agregar(Servicio entidad) {
        int idServicio = idGen.next();
        entidad.setIdServicio(idServicio);
        data.put(idServicio, entidad);
    }

    @Override
    public List<Servicio> listar() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Servicio buscarPorId(int idServicio) {
        return data.get(idServicio);
    }

    @Override
    public void actualizar(Servicio entidad) {
        if (data.containsKey(entidad.getIdServicio())) {
            data.put(entidad.getIdServicio(), entidad);
        }
    }

    @Override
    public void eliminar(int idServicio) {
        data.remove(idServicio);
    }
    
}
