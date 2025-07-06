package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Empleado;
import com.loganhotel.co.loganHotel.services.serviceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "apihotel/empleado")
public class controllerEmpleado {

    @Autowired
    private serviceEmpleado ServiceEmpleado;

    @GetMapping
    public List<Empleado> getAll (){ return ServiceEmpleado.getEmpleados();}

    @GetMapping("/{cedulaE}")
    public Optional<Empleado> getEmpleado(@PathVariable Long cedulaE){return ServiceEmpleado.getEmpleadoById(cedulaE);}

    @PostMapping
    public void saveOrUpdateEmpleado(@RequestBody Empleado empleado){ServiceEmpleado.saveOrUpdateEmpleado(empleado);}

    @DeleteMapping("/{cedulaE}")
    public void deleteEmpleado(@PathVariable Long cedulaE){ServiceEmpleado.deleteEmpleadoById(cedulaE);}

}
