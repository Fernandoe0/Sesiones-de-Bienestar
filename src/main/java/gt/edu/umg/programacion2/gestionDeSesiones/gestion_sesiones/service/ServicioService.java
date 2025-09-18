/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.service;

import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model.Servicio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository.Repositorio;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.validation.ValidadorServicio;
import java.util.List;

/**
 *
 * @author BICHO
 */
public class ServicioService {
    private final Repositorio<Servicio> repo;
    private final ValidadorServicio val;



    public ServicioService(Repositorio<Servicio> repo, ValidadorServicio val) {
        this.repo = repo;
        this.val = val;
    }
    
    
    public String registrarServicio(Servicio s) {
    

    if (!val.ServicioValido(s)){ return "Error: servicio nulo";}
    if (!val.nombreValido(s.getNombre())){ return "Error: nombre inválido";}
    if (!val.precioValido(s.getPrecio())){ return "Erorr: precio inválido";}
   
    repo.agregar(s);
    return "Servicio registrado exitosamente";
    }
    
    public List<Servicio> listar() {
        return repo.listar();
    }
   
    public Servicio buscarPorId(int idServicio) {
        return repo.listar().stream()
                .filter (f -> f.getIdServicio() == idServicio)
                .findFirst()
                .orElse(null);
    }
    
    public boolean eliminar(int idServicio) {
        Servicio s = buscarPorId(idServicio);
        if (s != null) {
            repo.eliminar(idServicio);
            return true;
        }
        return false;
    }
}
