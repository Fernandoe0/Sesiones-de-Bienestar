/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author BICHO
 */
@Entity
@Table (name = "factura")
public class Factura {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_factura")
private Long idFactura;
@Column(nullable=false)
private LocalDate fechaEmision;
@Column(nullable = false)
private BigDecimal monto;

@OneToOne
@JoinColumn(name = "cita_id", nullable = false, unique = true)
private Cita cita;

    public Factura() {
    }

    public Factura(LocalDate fechaEmision, BigDecimal monto, Cita cita) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.cita = cita;
    }

    public Long getIdFactura() {
        return idFactura;
    }
    
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }


}
