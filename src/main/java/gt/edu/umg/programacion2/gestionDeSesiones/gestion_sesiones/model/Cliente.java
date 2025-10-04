/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model;

import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author BICHO
 */
@Entity
@Table(name="clientes")
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_cliente")
private Long idCliente;
private String nombre;
@Column(unique = true, nullable = false)
private String correo;
private String telefono;

@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)

private List<Cita> citas;

public Cliente() {}

public Cliente(Long idCliente) { this.idCliente = idCliente;}
    public Cliente(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
    

    public Long getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    



}
