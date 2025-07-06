package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Hotel;
import com.loganhotel.co.loganHotel.repository.RepositoryHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHotel {

    @Autowired
    RepositoryHotel repoHotel;
    public List<Hotel> getHotels(){return repoHotel.findAll();}

    public Optional<Hotel> getHotelById(Long id){return repoHotel.findById(id);}

    public void saveOrUpdateHotel(Hotel hotel){ repoHotel.save(hotel);}

    public void deleteHotel(Hotel hotel){ repoHotel.delete(hotel); }
}
