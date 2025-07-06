package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Empleado;
import com.loganhotel.co.loganHotel.services.ServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/apihotel/empleado")
public class ControllerEmpleado {

    @Autowired
    private ServiceEmpleado serviceEmpleado;

    @GetMapping
    public List<Empleado> getAll (){ return serviceEmpleado.getEmpleados();}

    @GetMapping("/{cedulaE}")
    public Optional<Empleado> getEmpleado(@PathVariable Long cedulaE){return serviceEmpleado.getEmpleadoById(cedulaE);}

    @PostMapping
    public void saveOrUpdateEmpleado(@RequestBody Empleado empleado){
        serviceEmpleado.saveOrUpdateEmpleado(empleado);}

    @DeleteMapping("/{cedulaE}")
    public void deleteEmpleado(@PathVariable Long cedulaE){
        serviceEmpleado.deleteEmpleadoById(cedulaE);}

}
