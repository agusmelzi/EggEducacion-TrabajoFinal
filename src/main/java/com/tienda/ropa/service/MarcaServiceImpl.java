package com.tienda.ropa.service;

import com.tienda.ropa.entities.Marcas;
import com.tienda.ropa.repository.MarcaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepositorio repo;
    
    @Override
    public List<Marcas> listarMarcas() {
        return (List<Marcas>) repo.findAll();
    }

    @Override
    public void guardar(Marcas marca) {
        repo.save(marca);
    }

    @Override
    public void eliminar(Marcas marca) {
        repo.delete(marca);
    }

    @Override
    public Marcas encontrarMarcas(Marcas marca) {
        return repo.findById(marca.getIdMarca()).orElse(null);
    }
    
}
