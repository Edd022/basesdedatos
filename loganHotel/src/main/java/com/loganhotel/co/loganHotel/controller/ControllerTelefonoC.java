package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.TelefonoC;
import com.loganhotel.co.loganHotel.entity.TelefonoCId;
import com.loganhotel.co.loganHotel.services.ServiceTelefonoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/cliente-telefonos")
public class ControllerTelefonoC {

    @Autowired
    private ServiceTelefonoC serviceTelefonoC;

    @GetMapping
    public List<TelefonoC> getAll() {
        return serviceTelefonoC.getAllTelefonos();
    }

    @GetMapping("/{cedulaC}/{telefonoC}")
    public Optional<TelefonoC> getById(
            @PathVariable Long cedulaC,
            @PathVariable Long telefonoC) {
        return serviceTelefonoC.getTelefonoById(
            new TelefonoCId(cedulaC, telefonoC));
    }

    @PostMapping
    public void create(@RequestBody TelefonoC telefonoC) {
        serviceTelefonoC.saveOrUpdateTelefono(telefonoC);
    }

    @PutMapping("/{cedulaC}/{telefonoC}")
    public void update(
            @PathVariable Long cedulaC,
            @PathVariable Long telefonoC,
            @RequestBody TelefonoC nuevoTelefono) {
        nuevoTelefono.setCedulaC(cedulaC);
        nuevoTelefono.setTelefonoC(telefonoC);
        serviceTelefonoC.saveOrUpdateTelefono(nuevoTelefono);
    }

    @DeleteMapping("/{cedulaC}/{telefonoC}")
    public void delete(
            @PathVariable Long cedulaC,
            @PathVariable Long telefonoC) {
        serviceTelefonoC.deleteTelefonoById(
            new TelefonoCId(cedulaC, telefonoC));
    }
}