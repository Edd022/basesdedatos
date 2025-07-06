package com.loganhotel.co.loganHotel.repository;

import com.loganhotel.co.loganHotel.entity.Reserva;
import com.loganhotel.co.loganHotel.entity.ReservaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryReserva extends JpaRepository<Reserva, ReservaId> {
}