/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Cliente;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.util.IdGenerator;
import java.util.*;

/**
 *
 * @author BICHO
 */
public class ClienteRepositorioEnMemoria implements Repositorio<Cliente> {

    private final Map<Integer, Cliente> data = new HashMap<>();
    private final IdGenerator idGen = new IdGenerator();
    
    
    @Override
    public void agregar(Cliente c) {
        int idCliente = idGen.next();
        c.setIdCliente(idCliente);
        data.put(idCliente, c);
        
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Cliente buscarPorId(int idCliente) {
        return data.get(idCliente);
    }

    @Override
    public void actualizar(Cliente c) {
        if (data.containsKey(c.getIdCliente())) {
            data.put(c.getIdCliente(), c);
        }
    }

    @Override
    public void eliminar(int idCliente) {
        data.remove(idCliente);
    }
    
}
