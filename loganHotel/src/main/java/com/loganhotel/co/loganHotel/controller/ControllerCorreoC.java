package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.CorreoC;
import com.loganhotel.co.loganHotel.entity.CorreoCId;
import com.loganhotel.co.loganHotel.services.ServiceCorreoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/cliente-correos")
public class ControllerCorreoC {

    @Autowired
    private ServiceCorreoC serviceCorreoC;

    @GetMapping
    public List<CorreoC> getAll() {
        return serviceCorreoC.getAllCorreos();
    }

    @GetMapping("/{cedulaC}/{correoC}")
    public Optional<CorreoC> getById(
            @PathVariable Long cedulaC,
            @PathVariable String correoC) {
        return serviceCorreoC.getCorreoById(
            new CorreoCId(cedulaC, correoC));
    }

    @PostMapping
    public void create(@RequestBody CorreoC correoC) {
        serviceCorreoC.saveOrUpdateCorreo(correoC);
    }

    @PutMapping("/{cedulaC}/{correoC}")
    public void update(
            @PathVariable Long cedulaC,
            @PathVariable String correoC,
            @RequestBody CorreoC nuevoCorreo) {
        nuevoCorreo.setCedulaC(cedulaC);
        nuevoCorreo.setCorreoC(correoC);
        serviceCorreoC.saveOrUpdateCorreo(nuevoCorreo);
    }

    @DeleteMapping("/{cedulaC}/{correoC}")
    public void delete(
            @PathVariable Long cedulaC,
            @PathVariable String correoC) {
        serviceCorreoC.deleteCorreoById(
            new CorreoCId(cedulaC, correoC));
    }
}