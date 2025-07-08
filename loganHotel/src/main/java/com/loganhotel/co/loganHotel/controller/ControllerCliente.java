package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Cliente;
import com.loganhotel.co.loganHotel.services.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/apihotel/cliente")
public class ControllerCliente {

    @Autowired
    private ServiceCliente serviceCliente;

    @PreAuthorize("hasAnyRole('SERVICIO', 'RECEPCION', 'ADMINISTRACION')")
    @GetMapping
    public List<Cliente> getAll() {
        return serviceCliente.getAllClientes();
    }

    @PreAuthorize("hasAnyRole('SERVICIO', 'RECEPCION', 'ADMINISTRACION')")
    @GetMapping("/{cedulaC}")
    public Optional<Cliente> getById(@PathVariable Long cedulaC) {
        return serviceCliente.getClienteByCedula(cedulaC);
    }

    @PreAuthorize("hasAnyRole('SERVICIO', 'RECEPCION')")
    @PostMapping
    public void create(@RequestBody Cliente cliente) {
        serviceCliente.saveOrUpdateCliente(cliente);
    }

    @PreAuthorize("hasAnyRole('SERVICIO', 'RECEPCION')")
    @PutMapping("/{cedulaC}")
    public void update(@PathVariable Long cedulaC, @RequestBody Cliente nuevoCliente) {
        nuevoCliente.setCedulaC(cedulaC);
        serviceCliente.saveOrUpdateCliente(nuevoCliente);
    }

    @PreAuthorize("hasRole('ADMINISTRACION')")
    @DeleteMapping("/{cedulaC}")
    public void delete(@PathVariable Long cedulaC) {
        serviceCliente.deleteClienteByCedula(cedulaC);
    }
}