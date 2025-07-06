package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class OfreceId implements Serializable {

    @Column(name = "idhotel", nullable = false, precision = 4, scale = 0)
    private Long idhotel;

    @Column(name = "idservicio", nullable = false, precision = 3, scale = 0)
    private Long idservicio;

    public OfreceId(Long idhotel, Long idservicio) {
        this.idhotel = idhotel;
        this.idservicio = idservicio;
    }
}
