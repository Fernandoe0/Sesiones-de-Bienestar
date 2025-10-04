/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author BICHO
 */
@Entity
@Table(name = "cita")
public class Cita {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_cita")
private Long idCita;
private LocalDate fecha;
private LocalTime hora;
private String estado;

@ManyToOne
private Cliente cliente;

@ManyToOne
private Servicio servicio;

@OneToOne (mappedBy = "cita", cascade = CascadeType.ALL)
private Factura factura;

    public Cita() {
    }

    public Cita(LocalDate fecha, LocalTime hora, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }
    
    public Long getIdCita() {
        return idCita;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


}
