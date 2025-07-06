package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "caracteristicas", schema = "hotel")
@IdClass(CaracteristicaSId.class)
public class CaracteristicaS {

    @Id
    @Column(name = "idservicio", nullable = false, precision = 3)
    private Integer idServicio;

    @Id
    @Column(name = "caracteristica", nullable = false, length = 255)
    private String caracteristica;

    @ManyToOne
    @JoinColumn(name = "idservicio", insertable = false, updatable = false)
    private Servicio servicio;
}