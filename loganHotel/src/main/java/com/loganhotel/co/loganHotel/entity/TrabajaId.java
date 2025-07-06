package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class TrabajaId implements Serializable {

    @Column(name = "cedulaE", nullable = false, precision = 11, scale = 0)
    private Long cedulaE;

    @Column(name = "idhotel", nullable = false, precision = 4, scale = 0)
    private Long idHotel;

    public TrabajaId(Long cedulaE, Long idHotel) {
        this.cedulaE = cedulaE;
        this.idHotel = idHotel;
    }
}
