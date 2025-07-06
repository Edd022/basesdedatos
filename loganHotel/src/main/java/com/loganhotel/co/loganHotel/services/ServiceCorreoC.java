package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.CorreoC;
import com.loganhotel.co.loganHotel.entity.CorreoCId;
import com.loganhotel.co.loganHotel.repository.RepositoryCorreoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCorreoC {

    private final RepositoryCorreoC repositoryCorreoC;

    @Autowired
    public ServiceCorreoC(RepositoryCorreoC repositoryCorreoC) {
        this.repositoryCorreoC = repositoryCorreoC;
    }

    public List<CorreoC> getAllCorreos() {
        return repositoryCorreoC.findAll();
    }

    public Optional<CorreoC> getCorreoById(CorreoCId id) {
        return repositoryCorreoC.findById(id);
    }

    public CorreoC saveOrUpdateCorreo(CorreoC correo) {
        return repositoryCorreoC.save(correo);
    }

    public void deleteCorreoById(CorreoCId id) {
        repositoryCorreoC.deleteById(id);
    }
}