package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.CaracteristicaS;
import com.loganhotel.co.loganHotel.entity.CaracteristicaSId;
import com.loganhotel.co.loganHotel.services.ServiceCaracteristicaS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/caracteristicas")
public class ControllerCaracteristicaS {

    @Autowired
    private ServiceCaracteristicaS serviceCaracteristicaS;

    @GetMapping
    public List<CaracteristicaS> getAll() {
        return serviceCaracteristicaS.getAllCaracteristicas();
    }

    @GetMapping("/{idServicio}/{caracteristica}")
    public Optional<CaracteristicaS> getById(
            @PathVariable Integer idServicio,
            @PathVariable String caracteristica) {
        return serviceCaracteristicaS.getCaracteristicaById(
            new CaracteristicaSId(idServicio, caracteristica));
    }

    @PostMapping
    public void create(@RequestBody CaracteristicaS caracteristica) {
        serviceCaracteristicaS.saveOrUpdateCaracteristica(caracteristica);
    }

    @PutMapping("/{idServicio}/{caracteristica}")
    public void update(
            @PathVariable Integer idServicio,
            @PathVariable String caracteristica,
            @RequestBody CaracteristicaS nuevaCaracteristica) {
        nuevaCaracteristica.setIdServicio(idServicio);
        nuevaCaracteristica.setCaracteristica(caracteristica);
        serviceCaracteristicaS.saveOrUpdateCaracteristica(nuevaCaracteristica);
    }

    @DeleteMapping("/{idServicio}/{caracteristica}")
    public void delete(
            @PathVariable Integer idServicio,
            @PathVariable String caracteristica) {
        serviceCaracteristicaS.deleteCaracteristicaById(
            new CaracteristicaSId(idServicio, caracteristica));
    }
}