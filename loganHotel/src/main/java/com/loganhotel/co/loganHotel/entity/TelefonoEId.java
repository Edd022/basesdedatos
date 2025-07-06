package com.loganhotel.co.loganHotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor // obligatorio para JPA
public class TelefonoEId implements Serializable {

    @Column(name = "cedulaE", nullable = false, precision = 11, scale = 0)
    private Long cedulaE;

    @Column(name = "telefonoE", nullable = false, precision = 12, scale = 0)
    private Long telefonoE;

    // ⚠️ Agrega este constructor para poder crear la llave compuesta desde el controller
    public TelefonoEId(Long cedulaE, Long telefonoE) {
        this.cedulaE = cedulaE;
        this.telefonoE = telefonoE;
    }
}
