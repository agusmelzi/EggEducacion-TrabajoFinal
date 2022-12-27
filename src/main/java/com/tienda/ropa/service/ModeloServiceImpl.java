package com.tienda.ropa.service;


import com.tienda.ropa.entities.Modelos;
import com.tienda.ropa.repository.ModeloRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloServiceImpl implements ModeloService {

    
    @Autowired
    private ModeloRepositorio repo;
    
    @Override
    public List<Modelos> listarModelos() {
        return (List<Modelos>) repo.findAll();
    }

    @Override
    public void guardar(Modelos modelo) {
        repo.save(modelo);
    }

    @Override
    public void eliminar(Modelos modelo) {
        repo.delete(modelo);
    }

    @Override
    public Modelos encontrarModelos(Modelos modelo) {
        return repo.findById(modelo.getIdModelo()).orElse(null);
    }
    
}
