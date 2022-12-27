package com.tienda.ropa.service;

import com.tienda.ropa.entities.Talles;
import com.tienda.ropa.repository.TalleRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalleServiceImpl implements TalleService{
    
    @Autowired
    private TalleRepositorio repo;
    
    @Override
    public List<Talles> listarTalles() {
        return (List<Talles>) repo.findAll();
    }

    @Override
    public void guardar(Talles talle) {
        repo.save(talle);
    }

    @Override
    public void eliminar(Talles talle) {
        repo.delete(talle);
    }

    @Override
    public Talles encontrarTalles(Talles talle) {
        return repo.findById(talle.getIdTalle()).orElse(null);
    }
}
