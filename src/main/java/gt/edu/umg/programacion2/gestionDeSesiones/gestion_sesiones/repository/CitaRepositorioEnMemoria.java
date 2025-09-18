/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cita;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.util.IdGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BICHO
 */
public class CitaRepositorioEnMemoria implements Repositorio<Cita>{
   private final Map<Integer, Cita> data = new HashMap<>();
    private final IdGenerator idGen = new IdGenerator();
    
    
    @Override
    public void agregar(Cita d) {
        int idCita = idGen.next();
        d.setIdCita(idCita);
        data.put(idCita, d);
        
    }

    @Override
    public List<Cita> listar() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Cita buscarPorId(int idCita) {
        return data.get(idCita);
    }

    @Override
    public void actualizar(Cita d) {
        if (data.containsKey(d.getIdCita())) {
            data.put(d.getIdCita(), d);
        }
    }

    @Override
    public void eliminar(int idCita) {
        data.remove(idCita);
    } 
}
