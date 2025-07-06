package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.CaracteristicaS;
import com.loganhotel.co.loganHotel.entity.CaracteristicaSId;
import com.loganhotel.co.loganHotel.repository.RepositoryCaracteristicaS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCaracteristicaS {
    
    private final RepositoryCaracteristicaS repositoryCaracteristicaS;

    @Autowired
    public ServiceCaracteristicaS(RepositoryCaracteristicaS repositoryCaracteristicaS) {
        this.repositoryCaracteristicaS = repositoryCaracteristicaS;
    }

    public List<CaracteristicaS> getAllCaracteristicas() {
        return repositoryCaracteristicaS.findAll();
    }

    public Optional<CaracteristicaS> getCaracteristicaById(CaracteristicaSId id) {
        return repositoryCaracteristicaS.findById(id);
    }

    public CaracteristicaS saveOrUpdateCaracteristica(CaracteristicaS caracteristica) {
        return repositoryCaracteristicaS.save(caracteristica);
    }

    public void deleteCaracteristicaById(CaracteristicaSId id) {
        repositoryCaracteristicaS.deleteById(id);
    }
}