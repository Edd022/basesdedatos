package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "telefonoc", schema = "hotel")
@IdClass(TelefonoCId.class)
public class TelefonoC {

    @Id
    @Column(name = "cedulac", nullable = false, precision = 11)
    private Long cedulaC;

    @Id
    @Column(name = "telefonoc", nullable = false, precision = 12)
    private Long telefonoC;

    @ManyToOne
    @JoinColumn(name = "cedulac", referencedColumnName = "cedulac", insertable = false, updatable = false)
    private Cliente cliente;
}