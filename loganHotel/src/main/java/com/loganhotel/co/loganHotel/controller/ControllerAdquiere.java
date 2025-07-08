package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Adquiere;
import com.loganhotel.co.loganHotel.entity.AdquiereId;
import com.loganhotel.co.loganHotel.services.ServiceAdquiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/adquiere")
@PreAuthorize("hasAnyRole('SERVICIO', 'ADMINISTRACION')")  // Protege toda la clase para el rol SERVICIO
public class ControllerAdquiere {

    @Autowired
    private ServiceAdquiere serviceAdquiere;

    @GetMapping
    public List<Adquiere> getAll() {
        return serviceAdquiere.getAllAdquiere();
    }

    @GetMapping("/{cedulaC}/{idHabitacion}/{idServicio}/{fechaHora}")
    public Optional<Adquiere> getById(
            @PathVariable Long cedulaC,
            @PathVariable Integer idHabitacion,
            @PathVariable Integer idServicio,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora) {
        return serviceAdquiere.getAdquiereById(
            new AdquiereId(cedulaC, idHabitacion, idServicio, fechaHora));
    }

    @PostMapping
    public void create(@RequestBody Adquiere adquiere) {
        serviceAdquiere.saveOrUpdateAdquiere(adquiere);
    }

    @PutMapping("/{cedulaC}/{idHabitacion}/{idServicio}/{fechaHora}")
    public void update(
            @PathVariable Long cedulaC,
            @PathVariable Integer idHabitacion,
            @PathVariable Integer idServicio,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora,
            @RequestBody Adquiere nuevaAdquiere) {
        nuevaAdquiere.setCedulaC(cedulaC);
        nuevaAdquiere.setIdHabitacion(idHabitacion);
        nuevaAdquiere.setIdServicio(idServicio);
        nuevaAdquiere.setFechaHora(fechaHora);
        serviceAdquiere.saveOrUpdateAdquiere(nuevaAdquiere);
    }

    @DeleteMapping("/{cedulaC}/{idHabitacion}/{idServicio}/{fechaHora}")
    @PreAuthorize("hasRole('ADMINISTRACION')")  // Solo el admin puede borrar
    public void delete(
            @PathVariable Long cedulaC,
            @PathVariable Integer idHabitacion,
            @PathVariable Integer idServicio,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora) {
        serviceAdquiere.deleteAdquiereById(
            new AdquiereId(cedulaC, idHabitacion, idServicio, fechaHora));
    }
}