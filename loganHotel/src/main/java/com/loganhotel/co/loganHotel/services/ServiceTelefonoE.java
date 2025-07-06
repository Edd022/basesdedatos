package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.TelefonoE;
import com.loganhotel.co.loganHotel.entity.TelefonoEId;
import com.loganhotel.co.loganHotel.repository.RepositoryTelefonoE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTelefonoE {

    private final RepositoryTelefonoE repositoryTelefonoE;

    @Autowired
    public ServiceTelefonoE(RepositoryTelefonoE repositoryTelefonoE) {
        this.repositoryTelefonoE = repositoryTelefonoE;
    }

    public List<TelefonoE> getAllTelefonos() {
        return repositoryTelefonoE.findAll();
    }

    public Optional<TelefonoE> getTelefonoById(TelefonoEId id) {
        return repositoryTelefonoE.findById(id);
    }

    public TelefonoE saveOrUpdateTelefono(TelefonoE telefonoE) {
        return repositoryTelefonoE.save(telefonoE);
    }

    public void deleteTelefonoById(TelefonoEId id) {
        repositoryTelefonoE.deleteById(id);
    }
}
