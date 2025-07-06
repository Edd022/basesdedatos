package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Trabaja;
import com.loganhotel.co.loganHotel.entity.TrabajaId;
import com.loganhotel.co.loganHotel.repository.RepositoryTrabaja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTrabaja {
    private RepositoryTrabaja repoTrabaja;

    @Autowired
    public ServiceTrabaja(RepositoryTrabaja repoTrabaja) {
        this.repoTrabaja = repoTrabaja;
    }

    public List<Trabaja> getTrabajadores() { return repoTrabaja.findAll();}

    public Optional<Trabaja> getTrabajadorById (TrabajaId Id) {return repoTrabaja.findById(Id);}

    public Trabaja saveOrUpdateTrabajador(Trabaja trabajador) {return repoTrabaja.save(trabajador);}

    public void deleteTrajadorById(TrabajaId Id) {repoTrabaja.deleteById(Id);}

}
