package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Reserva;
import com.loganhotel.co.loganHotel.entity.ReservaId;
import com.loganhotel.co.loganHotel.repository.RepositoryReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceReserva {

    private final RepositoryReserva repositoryReserva;

    @Autowired
    public ServiceReserva(RepositoryReserva repositoryReserva) {
        this.repositoryReserva = repositoryReserva;
    }

    public List<Reserva> getAllReservas() {
        return repositoryReserva.findAll();
    }

    public Optional<Reserva> getReservaById(ReservaId id) {
        return repositoryReserva.findById(id);
    }

    public Reserva saveOrUpdateReserva(Reserva reserva) {
        return repositoryReserva.save(reserva);
    }

    public void deleteReservaById(ReservaId id) {
        repositoryReserva.deleteById(id);
    }
}