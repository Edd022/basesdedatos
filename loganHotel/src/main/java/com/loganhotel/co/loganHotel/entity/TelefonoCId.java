package com.loganhotel.co.loganHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoCId implements Serializable {
    private Long cedulaC;
    private Long telefonoC;
}