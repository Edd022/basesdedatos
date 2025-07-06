package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Ofrece;
import com.loganhotel.co.loganHotel.entity.OfreceId;
import com.loganhotel.co.loganHotel.repository.RepositoryOfrece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOfrece {
    private final RepositoryOfrece repoOFrece;

    @Autowired
    public ServiceOfrece(RepositoryOfrece repoOFrece) {
        this.repoOFrece = repoOFrece;
    }

    public List<Ofrece> getAllOfrece(){return repoOFrece.findAll();}

    public Optional<Ofrece> getOfreceById(OfreceId ofrece){return repoOFrece.findById(ofrece);}

    public Ofrece saveOrUpdateOfrece(Ofrece ofrece){return repoOFrece.save(ofrece);}

    public void deleteOfreceById(OfreceId ofrece){repoOFrece.deleteById(ofrece);}
}
