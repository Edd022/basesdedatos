package com.loganhotel.co.loganHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaId implements Serializable {
    private Integer idHabitacion;
    private Long cedulaC;
    private LocalDateTime fechaLlegada;
}