package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Empleado;
import com.loganhotel.co.loganHotel.repository.repositoryEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceEmpleado {

    @Autowired
    repositoryEmpleado repoEmpleado;
    public List<Empleado> getEmpleados() {return repoEmpleado.findAll();}

    public Optional<Empleado> getEmpleadoById(long cedulaE) {return repoEmpleado.findById(cedulaE);}

    public void saveOrUpdateEmpleado(Empleado empleado) {repoEmpleado.save(empleado);}

    public void deleteEmpleadoById(long id) {repoEmpleado.deleteById(id);}
}
