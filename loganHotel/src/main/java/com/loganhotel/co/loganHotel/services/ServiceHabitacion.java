package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Habitacion;
import com.loganhotel.co.loganHotel.repository.RepositoryHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHabitacion {

    private final RepositoryHabitacion repositoryHabitacion;

    @Autowired
    public ServiceHabitacion(RepositoryHabitacion repositoryHabitacion) {
        this.repositoryHabitacion = repositoryHabitacion;
    }

    public List<Habitacion> getAllHabitaciones() {
        return repositoryHabitacion.findAll();
    }

    public Optional<Habitacion> getHabitacionById(Integer idHabitacion) {
        return repositoryHabitacion.findById(idHabitacion);
    }

    public Habitacion saveOrUpdateHabitacion(Habitacion habitacion) {
        return repositoryHabitacion.save(habitacion);
    }

    public void deleteHabitacionById(Integer idHabitacion) {
        repositoryHabitacion.deleteById(idHabitacion);
    }
}