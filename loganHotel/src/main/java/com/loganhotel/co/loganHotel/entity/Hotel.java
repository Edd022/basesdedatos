package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "hotel", schema = "hotel")
public class Hotel {
    @Id
    @Column (name = "idhotel", nullable = false, precision = 4, scale = 0)
    private long id;

    @Column (name = "nombreh", length = 255)
    private String nombre;
}
