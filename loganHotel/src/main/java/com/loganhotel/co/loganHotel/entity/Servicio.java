package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "servicio", schema = "hotel")
public class Servicio {

    /**
     * En la base es NUMERIC(3),
     * que puede tener hasta 3 dígitos: mejor Integer que Long.
     */
    @Id
    @Column(name = "idservicio", nullable = false, precision = 3, scale = 0)
    private Integer idServicio;

    @Column(name = "nombreservicio", nullable = false, length = 255)
    private String nombreServicio;

    @Column(name = "costos", nullable = false, precision = 6, scale = 0)
    private Integer costoS;
}