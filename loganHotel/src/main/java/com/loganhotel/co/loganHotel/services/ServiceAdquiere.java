package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Adquiere;
import com.loganhotel.co.loganHotel.entity.AdquiereId;
import com.loganhotel.co.loganHotel.repository.RepositoryAdquiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdquiere {

    private final RepositoryAdquiere repositoryAdquiere;

    @Autowired
    public ServiceAdquiere(RepositoryAdquiere repositoryAdquiere) {
        this.repositoryAdquiere = repositoryAdquiere;
    }

    public List<Adquiere> getAllAdquiere() {
        return repositoryAdquiere.findAll();
    }

    public Optional<Adquiere> getAdquiereById(AdquiereId id) {
        return repositoryAdquiere.findById(id);
    }

    public Adquiere saveOrUpdateAdquiere(Adquiere adquiere) {
        return repositoryAdquiere.save(adquiere);
    }

    public void deleteAdquiereById(AdquiereId id) {
        repositoryAdquiere.deleteById(id);
    }
}