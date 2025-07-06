package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Servicio;
import com.loganhotel.co.loganHotel.repository.RepositoryServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServicio {
    private RepositoryServicio repoServicio;

    @Autowired
    public ServiceServicio(RepositoryServicio repoServicio) {
        this.repoServicio = repoServicio;
    }

    public List<Servicio> getServicios() {
        return repoServicio.findAll();
    }

    public Optional<Servicio> getServicioById(Integer id) {
        return repoServicio.findById(id);
    }

    public Servicio saveOrUpdateServicio(Servicio servicio) {
        return repoServicio.save(servicio);
    }

    public void deleteServicioById(Integer id) {
        repoServicio.deleteById(id);
    }
}