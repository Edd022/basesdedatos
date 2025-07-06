package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "correoc", schema = "hotel")
@IdClass(CorreoCId.class)
public class CorreoC {

    @Id
    @Column(name = "cedulac", nullable = false, precision = 11)
    private Long cedulaC;

    @Id
    @Column(name = "correoc", nullable = false, length = 255)
    private String correoC;

    @ManyToOne
    @JoinColumn(name = "cedulac", referencedColumnName = "cedulac", insertable = false, updatable = false)
    private Cliente cliente;
}