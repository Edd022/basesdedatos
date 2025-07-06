package com.loganhotel.co.loganHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdquiereId implements Serializable {
    private Long cedulaC;
    private Integer idHabitacion;
    private Integer idServicio;
    private LocalDateTime fechaHora;
}