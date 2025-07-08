package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "habitacion", schema = "hotel")
public class Habitacion {

    @Id
    @Column(name = "idhabitacion", nullable = false, precision = 4)
    private Integer idHabitacion;

    @Column(name = "idhotel", nullable = false, precision = 4)
    private Integer idHotel;

    @Column(name = "idcategoria", nullable = true)
    private Integer idCategoria;

    @Column(name = "estadodisponibilidad")
    private Boolean estadoDisponibilidad;

    @Column(name = "precionoche", precision = 7)
    private BigDecimal precioNoche;

    @ManyToOne
    @JoinColumn(name = "idhotel", referencedColumnName = "idhotel", insertable = false, updatable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria", insertable = false, updatable = false)
    private Categoria categoria;
}