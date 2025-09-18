/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Usuario;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.util.IdGenerator;
import java.util.*;

/**
 *
 * @author BICHO
 */
public class UsuarioRepositorioEnMemoria implements Repositorio<Usuario> {
    private final Map<Integer, Usuario> data = new HashMap<>();
    private final IdGenerator idGen = new IdGenerator();
    
    
    @Override
    public void agregar(Usuario entidad) {
        int idUsuario = idGen.next();
        entidad.setIdUsuario(idUsuario);
        data.put(idUsuario, entidad);

    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(data.values());

    }

    @Override
    public Usuario buscarPorId(int idServicio) {
        return data.get(idServicio);

    }

    @Override
    public void actualizar(Usuario entidad) {
        if (data.containsKey(entidad.getIdUsuario())) {
            data.put(entidad.getIdUsuario(), entidad);
        }

    }

    @Override
    public void eliminar(int idServicio) {
       data.remove(idServicio);

    }
    
}
