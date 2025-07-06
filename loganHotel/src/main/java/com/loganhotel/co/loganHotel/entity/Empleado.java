package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empleado", schema = "hotel")
public class Empleado {

    /**
     * En la base es NUMERIC(11),
     * que puede tener hasta 11 dígitos: mejor Long que int.
     */
    @Id
    @Column(name = "cedulaE", nullable = false, precision = 11, scale = 0)
    private Long cedulaE;

    @Column(name = "primerNE", nullable = false, length = 255)
    private String primerNE;

    @Column(name = "segundoNE", length = 255)
    private String segundoNE;

    @Column(name = "primerAE", nullable = false, length = 255)
    private String primerAE;

    @Column(name = "segundoAE", length = 255)
    private String segundoAE;

    @Column(name = "calleE", length = 255)
    private String calleE;

    @Column(name = "carreraE", length = 255)
    private String carreraE;

    /** Si tus números de “casa” incluyen letras, mejor String */
    @Column(name = "numeroE", length = 20)
    private String numeroE;

    @Column(name = "cargo", length = 255)
    private String cargo;

    @Column(name = "area", length = 255)
    private String area;
}
