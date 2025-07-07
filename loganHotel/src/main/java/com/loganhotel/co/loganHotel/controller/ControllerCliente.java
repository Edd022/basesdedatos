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
@PreAuthorize("hasRole('RECEPCION')")  // Solo recepción puede acceder
public class ControllerCliente {

    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping
    public List<Cliente> getAll() {
        return serviceCliente.getAllClientes();
    }

    @GetMapping("/{cedulaC}")
    public Optional<Cliente> getById(@PathVariable Long cedulaC) {
        return serviceCliente.getClienteByCedula(cedulaC);
    }

    @PostMapping
    public void create(@RequestBody Cliente cliente) {
        serviceCliente.saveOrUpdateCliente(cliente);
    }

    @PutMapping("/{cedulaC}")
    public void update(@PathVariable Long cedulaC, @RequestBody Cliente nuevoCliente) {
        nuevoCliente.setCedulaC(cedulaC);
        serviceCliente.saveOrUpdateCliente(nuevoCliente);
    }

    @DeleteMapping("/{cedulaC}")
    @PreAuthorize("hasRole('ADMINISTRACION')")  // Solo admin puede borrar
    public void delete(@PathVariable Long cedulaC) {
        serviceCliente.deleteClienteByCedula(cedulaC);
    }
}