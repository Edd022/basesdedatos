package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.TelefonoE;
import com.loganhotel.co.loganHotel.entity.TelefonoEId;
import com.loganhotel.co.loganHotel.entity.Trabaja;
import com.loganhotel.co.loganHotel.entity.TrabajaId;
import com.loganhotel.co.loganHotel.services.ServiceTrabaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/apihotel/empleado-trabaja")
public class controllerTrabaja {
    @Autowired
    private ServiceTrabaja serviceTrabaja;

    @GetMapping
    public List<Trabaja> getTrabajadores() {
        return serviceTrabaja.getTrabajadores();
    }

    @GetMapping("/{cedulaE}/{idHotel}")
    public Optional getTrabajador(@PathVariable Long cedulaE, @PathVariable Long idHotel) {
        return serviceTrabaja.getTrabajadorById(new TrabajaId(cedulaE, idHotel));
    }

    @PostMapping
    public void create(@RequestBody Trabaja trabajador) {
        serviceTrabaja.saveOrUpdateTrabajador(trabajador);
    }

    @PutMapping("/{cedulaE}/{idHotel}")
    public void update(@PathVariable Long cedulaE,
                       @PathVariable Long idHotel,
                       @RequestBody Trabaja nuevoTrabajador) {
        nuevoTrabajador.setId(new TrabajaId(cedulaE, idHotel));
        serviceTrabaja.saveOrUpdateTrabajador(nuevoTrabajador);
    }

    @DeleteMapping("/{cedulaE}/{idHotel}")
    public void delete(@PathVariable Long cedulaE, @PathVariable Long idHotel) {
        serviceTrabaja.deleteTrajadorById(new TrabajaId(cedulaE, idHotel));
    }
}
