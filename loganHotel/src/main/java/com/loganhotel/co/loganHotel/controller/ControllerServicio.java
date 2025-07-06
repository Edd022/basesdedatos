package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Servicio;
import com.loganhotel.co.loganHotel.services.ServiceServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/apihotel/servicio")
public class ControllerServicio {

    @Autowired
    private ServiceServicio serviceServicio;

    @GetMapping
    public List<Servicio> getAll() {
        return serviceServicio.getServicios();
    }

    @GetMapping("/{idServicio}")
    public Optional<Servicio> getServicio(@PathVariable Integer idServicio) {
        return serviceServicio.getServicioById(idServicio);
    }

    @PostMapping
    public void saveOrUpdateServicio(@RequestBody Servicio servicio) {
        serviceServicio.saveOrUpdateServicio(servicio);
    }

    @DeleteMapping("/{idServicio}")
    public void deleteServicio(@PathVariable Integer idServicio) {
        serviceServicio.deleteServicioById(idServicio);
    }
}