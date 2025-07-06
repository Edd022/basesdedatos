package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Categoria;
import com.loganhotel.co.loganHotel.repository.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoria {

    private final RepositoryCategoria repositoryCategoria;

    @Autowired
    public ServiceCategoria(RepositoryCategoria repositoryCategoria) {
        this.repositoryCategoria = repositoryCategoria;
    }

    public List<Categoria> getAllCategorias() {
        return repositoryCategoria.findAll();
    }

    public Optional<Categoria> getCategoriaById(Integer idCategoria) {
        return repositoryCategoria.findById(idCategoria);
    }

    public Categoria saveOrUpdateCategoria(Categoria categoria) {
        return repositoryCategoria.save(categoria);
    }

    public void deleteCategoriaById(Integer idCategoria) {
        repositoryCategoria.deleteById(idCategoria);
    }
}