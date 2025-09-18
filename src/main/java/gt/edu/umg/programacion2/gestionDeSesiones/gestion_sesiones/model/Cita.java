/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model;

import jakarta.persistence.*;

/**
 *
 * @author BICHO
 */
@Entity
public class Cita {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int idCita;
private String fecha;
private String hora;
private String estado;

@ManyToOne
private Cliente cliente;

@ManyToOne
private Servicio servicio;

@OneToOne (mappedBy = "cita", cascade = CascadeType.ALL)
private Factura factura;

    public Cita() {
    }

    /*public Cita(String fecha, String hora, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }*/

    public Cita(int idCita, String fecha, String hora, String estado, Cliente cliente, Servicio servicio) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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


}
