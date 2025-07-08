package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Reserva;
import com.loganhotel.co.loganHotel.entity.ReservaId;
import com.loganhotel.co.loganHotel.services.ServiceReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/reserva")
@PreAuthorize("hasAnyRole('RECEPCION', 'ADMINISTRACION')")
public class ControllerReserva {

    @Autowired
    private ServiceReserva serviceReserva;

    @GetMapping
    public List<Reserva> getAll() {
        return serviceReserva.getAllReservas();
    }

    @GetMapping("/{idHabitacion}/{cedulaC}/{fechaLlegada}")
    public Optional<Reserva> getById(
            @PathVariable Integer idHabitacion,
            @PathVariable Long cedulaC,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaLlegada) {
        return serviceReserva.getReservaById(
            new ReservaId(idHabitacion, cedulaC, fechaLlegada));
    }

    @PostMapping
    public void create(@RequestBody Reserva reserva) {
        serviceReserva.saveOrUpdateReserva(reserva);
    }

    @PutMapping("/{idHabitacion}/{cedulaC}/{fechaLlegada}")
    public void update(
            @PathVariable Integer idHabitacion,
            @PathVariable Long cedulaC,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaLlegada,
            @RequestBody Reserva nuevaReserva) {
        nuevaReserva.setIdHabitacion(idHabitacion);
        nuevaReserva.setCedulaC(cedulaC);
        nuevaReserva.setFechaLlegada(fechaLlegada);
        serviceReserva.saveOrUpdateReserva(nuevaReserva);
    }

    @PreAuthorize("hasRole('ADMINISTRACION')")
    @DeleteMapping("/{idHabitacion}/{cedulaC}/{fechaLlegada}")
    public void delete(
            @PathVariable Integer idHabitacion,
            @PathVariable Long cedulaC,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaLlegada) {
        serviceReserva.deleteReservaById(
            new ReservaId(idHabitacion, cedulaC, fechaLlegada));
    }
}