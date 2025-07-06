package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.TelefonoC;
import com.loganhotel.co.loganHotel.entity.TelefonoCId;
import com.loganhotel.co.loganHotel.repository.RepositoryTelefonoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTelefonoC {

    private final RepositoryTelefonoC repositoryTelefonoC;

    @Autowired
    public ServiceTelefonoC(RepositoryTelefonoC repositoryTelefonoC) {
        this.repositoryTelefonoC = repositoryTelefonoC;
    }

    public List<TelefonoC> getAllTelefonos() {
        return repositoryTelefonoC.findAll();
    }

    public Optional<TelefonoC> getTelefonoById(TelefonoCId id) {
        return repositoryTelefonoC.findById(id);
    }

    public TelefonoC saveOrUpdateTelefono(TelefonoC telefono) {
        return repositoryTelefonoC.save(telefono);
    }

    public void deleteTelefonoById(TelefonoCId id) {
        repositoryTelefonoC.deleteById(id);
    }
}