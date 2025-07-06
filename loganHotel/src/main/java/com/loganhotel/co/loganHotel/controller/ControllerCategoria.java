package com.loganhotel.co.loganHotel.controller;

import com.loganhotel.co.loganHotel.entity.Categoria;
import com.loganhotel.co.loganHotel.services.ServiceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apihotel/categoria")
public class ControllerCategoria {

    @Autowired
    private ServiceCategoria serviceCategoria;

    @GetMapping
    public List<Categoria> getAll() {
        return serviceCategoria.getAllCategorias();
    }

    @GetMapping("/{idCategoria}")
    public Optional<Categoria> getById(@PathVariable Integer idCategoria) {
        return serviceCategoria.getCategoriaById(idCategoria);
    }

    @PostMapping
    public void create(@RequestBody Categoria categoria) {
        serviceCategoria.saveOrUpdateCategoria(categoria);
    }

    @PutMapping("/{idCategoria}")
    public void update(
            @PathVariable Integer idCategoria,
            @RequestBody Categoria nuevaCategoria) {
        nuevaCategoria.setIdCategoria(idCategoria);
        serviceCategoria.saveOrUpdateCategoria(nuevaCategoria);
    }

    @DeleteMapping("/{idCategoria}")
    public void delete(@PathVariable Integer idCategoria) {
        serviceCategoria.deleteCategoriaById(idCategoria);
    }
}