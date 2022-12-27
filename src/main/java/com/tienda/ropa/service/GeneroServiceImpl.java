package com.tienda.ropa.service;

import com.tienda.ropa.entities.Generos;
import com.tienda.ropa.repository.GenerosRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GenerosRepositorio repo;
    
    @Override
    public List<Generos> listarGeneros() {
        return (List<Generos>) repo.findAll();
    }

    @Override
    public void guardar(Generos genero) {
        repo.save(genero);
    }

    @Override
    public void eliminar(Generos genero) {
        repo.delete(genero);
    }

    @Override
    public Generos encontrarGenero(Generos genero) {
        return repo.findById(genero.getIdGenero()).orElse(null);
    }
    
    
}
