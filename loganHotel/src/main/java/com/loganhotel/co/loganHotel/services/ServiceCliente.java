package com.loganhotel.co.loganHotel.services;

import com.loganhotel.co.loganHotel.entity.Cliente;
import com.loganhotel.co.loganHotel.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCliente {

    private final RepositoryCliente repositoryCliente;

    @Autowired
    public ServiceCliente(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }

    public List<Cliente> getAllClientes() {
        return repositoryCliente.findAll();
    }

    public Optional<Cliente> getClienteByCedula(Long cedulaC) {
        return repositoryCliente.findById(cedulaC);
    }

    public Cliente saveOrUpdateCliente(Cliente cliente) {
        return repositoryCliente.save(cliente);
    }

    public void deleteClienteByCedula(Long cedulaC) {
        repositoryCliente.deleteById(cedulaC);
    }
}