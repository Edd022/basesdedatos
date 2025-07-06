package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria", schema = "hotel")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria", nullable = false)
    private Integer idCategoria;

    @Column(name = "nombrecategoria", length = 255)
    private String nombreCategoria;
}