package com.loganhotel.co.loganHotel.repository;

import com.loganhotel.co.loganHotel.entity.TelefonoE;
import com.loganhotel.co.loganHotel.entity.TelefonoEId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTelefonoE extends JpaRepository<TelefonoE, TelefonoEId> {
}
