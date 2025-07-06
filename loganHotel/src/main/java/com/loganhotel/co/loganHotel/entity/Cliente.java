package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente", schema = "hotel")
public class Cliente {

    @Id
    @Column(name = "cedulac", nullable = false, precision = 11)
    private Long cedulaC;

    @Column(name = "primernc", nullable = false, length = 255)
    private String primerNC;

    @Column(name = "segundonc", length = 255)
    private String segundoNC;

    @Column(name = "primerac", nullable = false, length = 255)
    private String primerAC;

    @Column(name = "segundoac", length = 255)
    private String segundoAC;

    @Column(name = "callec", length = 255)
    private String calleC;

    @Column(name = "carrerac", length = 255)
    private String carreraC;

    @Column(name = "numeroc", length = 20)
    private String numeroC;
}