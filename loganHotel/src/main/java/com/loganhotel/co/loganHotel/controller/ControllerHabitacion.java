package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Habitacion;
import com.loganhotel.co.loganHotel.services.ServiceHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/habitacion")
public class ControllerHabitacion {

    @Autowired
    private ServiceHabitacion serviceHabitacion;

    @GetMapping
    public List<Habitacion> getAll() {
        return serviceHabitacion.getAllHabitaciones();
    }

    @GetMapping("/{idHabitacion}")
    public Optional<Habitacion> getById(@PathVariable Integer idHabitacion) {
        return serviceHabitacion.getHabitacionById(idHabitacion);
    }

    @PostMapping
    public void create(@RequestBody Habitacion habitacion) {
        serviceHabitacion.saveOrUpdateHabitacion(habitacion);
    }

    @PutMapping("/{idHabitacion}")
    public void update(
            @PathVariable Integer idHabitacion,
            @RequestBody Habitacion nuevaHabitacion) {
        nuevaHabitacion.setIdHabitacion(idHabitacion);
        serviceHabitacion.saveOrUpdateHabitacion(nuevaHabitacion);
    }

    @DeleteMapping("/{idHabitacion}")
    public void delete(@PathVariable Integer idHabitacion) {
        serviceHabitacion.deleteHabitacionById(idHabitacion);
    }
}