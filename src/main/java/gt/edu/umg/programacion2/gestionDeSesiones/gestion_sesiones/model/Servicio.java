/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BICHO
 */
@Entity
@Table(name = "servicios")
public class Servicio {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_servicio")
private Long idServicio;
@Column(nullable = false, length = 100)
private String nombre;
@Column(length = 255)
private String descripcion;
@Column(nullable = false, precision = 10, scale = 2)
private BigDecimal precio;

@OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Cita> citas = new ArrayList<>();

    public Servicio() {
    }

    public Servicio(String nombre, String descripcion, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }    

    public Long getIdServicio() {
        return idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }


}
