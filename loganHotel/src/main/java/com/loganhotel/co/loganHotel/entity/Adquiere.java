package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "adquiere", schema = "hotel")
@IdClass(AdquiereId.class)
public class Adquiere {

    @Id
    @Column(name = "cedulac", nullable = false, precision = 11)
    private Long cedulaC;

    @Id
    @Column(name = "idhabitacion", nullable = false, precision = 4)
    private Integer idHabitacion;

    @Id
    @Column(name = "idservicio", nullable = false, precision = 3)
    private Integer idServicio;

    @Id
    @Column(name = "fechahora", nullable = false)
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "cedulac", referencedColumnName = "cedulac", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idhabitacion", referencedColumnName = "idhabitacion", insertable = false, updatable = false)
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio", insertable = false, updatable = false)
    private Servicio servicio;
}