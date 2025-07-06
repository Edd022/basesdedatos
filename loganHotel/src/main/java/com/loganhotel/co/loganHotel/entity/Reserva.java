package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reserva", schema = "hotel")
@IdClass(ReservaId.class)
public class Reserva {

    @Id
    @Column(name = "idhabitacion", nullable = false, precision = 4)
    private Integer idHabitacion;

    @Id
    @Column(name = "cedulac", nullable = false, precision = 11)
    private Long cedulaC;

    @Id
    @Column(name = "fechallegada", nullable = false)
    private LocalDateTime fechaLlegada;

    @Column(name = "detalle", length = 255)
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "idhabitacion", referencedColumnName = "idhabitacion", insertable = false, updatable = false)
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "cedulac", referencedColumnName = "cedulac", insertable = false, updatable = false)
    private Cliente cliente;
}