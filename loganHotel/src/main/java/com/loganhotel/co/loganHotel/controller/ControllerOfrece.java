package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Ofrece;
import com.loganhotel.co.loganHotel.entity.OfreceId;
import com.loganhotel.co.loganHotel.services.ServiceOfrece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/ofrece")
@PreAuthorize("hasAnyRole('ADMINISTRACION', 'SERVICIO')")
public class ControllerOfrece {

    @Autowired
    private ServiceOfrece serviceOfrece;

    @GetMapping
    public List<Ofrece> getAll() {return serviceOfrece.getAllOfrece();}

    @GetMapping("/{idhotel}/{idservicio}")
    public Optional<Ofrece> getById(@PathVariable Long idhotel, @PathVariable Long idservicio) {
        return serviceOfrece.getOfreceById(new OfreceId(idhotel, idservicio));
    }

    @PostMapping
    public void create(@RequestBody Ofrece ofrece) {serviceOfrece.saveOrUpdateOfrece(ofrece);}

    @PutMapping("/{idhotel}/{idservicio}")
    public void update (@PathVariable Long idhotel,
                        @PathVariable Long idservicio,
                        @RequestBody Ofrece nuevoOfrece){
        nuevoOfrece.setId(new OfreceId(idhotel, idservicio));
        serviceOfrece.saveOrUpdateOfrece(nuevoOfrece);
    }

    @PreAuthorize("hasRole('ADMINISTRACION')")
    @DeleteMapping("/{idhotel}/{idservicio}")
    public void delete (@PathVariable Long idhotel, @PathVariable Long idservicio) {
        serviceOfrece.deleteOfreceById(new OfreceId(idhotel, idservicio));
    }
}
