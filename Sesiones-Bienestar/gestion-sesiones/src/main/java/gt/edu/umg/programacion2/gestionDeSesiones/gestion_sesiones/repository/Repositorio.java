/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.repository;

import java.util.List;

/**
 *
 * @author BICHO
 */
public interface Repositorio<T> {
    void agregar( T entidad);
    List<T> listar();
    T buscarPorId(int id);
    void actualizar(T entidad);
    void eliminar(int id);
}
