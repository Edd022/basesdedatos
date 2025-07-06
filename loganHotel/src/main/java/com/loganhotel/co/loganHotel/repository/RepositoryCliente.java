package com.loganhotel.co.loganHotel.repository;

import com.loganhotel.co.loganHotel.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
}