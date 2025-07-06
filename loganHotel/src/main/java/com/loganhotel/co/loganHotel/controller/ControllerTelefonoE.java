package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.TelefonoE;
import com.loganhotel.co.loganHotel.entity.TelefonoEId;
import com.loganhotel.co.loganHotel.services.ServiceTelefonoE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/empleado-telefonos")
public class ControllerTelefonoE {

    @Autowired
    private ServiceTelefonoE serviceTelefonoE;

    @GetMapping
    public List<TelefonoE> getAll() {
        return serviceTelefonoE.getAllTelefonos();
    }

    @GetMapping("/{cedulaE}/{telefonoE}")
    public Optional<TelefonoE> getById(@PathVariable Long cedulaE, @PathVariable Long telefonoE) {
        return serviceTelefonoE.getTelefonoById(new TelefonoEId(cedulaE, telefonoE));
    }

    @PostMapping
    public void create(@RequestBody TelefonoE telefonoE) {
        serviceTelefonoE.saveOrUpdateTelefono(telefonoE);
    }

    @PutMapping("/{cedulaE}/{telefonoE}")
    public void update(@PathVariable Long cedulaE,
                       @PathVariable Long telefonoE,
                       @RequestBody TelefonoE nuevoTelefono) {
        nuevoTelefono.setId(new TelefonoEId(cedulaE, telefonoE));
        serviceTelefonoE.saveOrUpdateTelefono(nuevoTelefono);
    }

    @DeleteMapping("/{cedulaE}/{telefonoE}")
    public void delete(@PathVariable Long cedulaE, @PathVariable Long telefonoE) {
        serviceTelefonoE.deleteTelefonoById(new TelefonoEId(cedulaE, telefonoE));
    }
}
