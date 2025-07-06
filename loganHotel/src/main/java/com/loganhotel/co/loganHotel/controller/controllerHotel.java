package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Hotel;
import com.loganhotel.co.loganHotel.services.ServiceHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/apihotel/hotel")
public class controllerHotel {

    @Autowired
    private ServiceHotel serviceHotel;

    @GetMapping
    public List<Hotel> getAll() {return serviceHotel.getHotels();}

    @GetMapping("/{idHotel}")
    public Optional<Hotel> getHotelById(@PathVariable Long idHotel) {return serviceHotel.getHotelById(idHotel);}

    @PostMapping
    public void saveOrUpdateHotel(@RequestBody Hotel hotel) {serviceHotel.saveOrUpdateHotel(hotel);}

    @DeleteMapping("/{idHotel}")
    public void deleteHotel (@PathVariable Hotel hotel){serviceHotel.deleteHotel(hotel);}
}
