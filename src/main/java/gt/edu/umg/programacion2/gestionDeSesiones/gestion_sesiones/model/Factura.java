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
public class Factura {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idFactura;
private String fechaEmision;
private double monto;

@OneToOne
@JoinColumn(name = "cita_id")
private Cita cita;

    public Factura() {
    }

    public Factura(int idFactura, String fechaEmision, double monto) {
        this.idFactura = idFactura;
        this.fechaEmision = fechaEmision;
        this.monto = monto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


}
