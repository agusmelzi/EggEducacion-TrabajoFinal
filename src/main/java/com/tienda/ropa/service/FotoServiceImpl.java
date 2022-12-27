package com.tienda.ropa.service;

import com.tienda.ropa.entities.Foto;
import com.tienda.ropa.repository.FotoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoServiceImpl implements FotoService {

    @Autowired
    private FotoRepo repo;
    
    @Override
    public List<Foto> listarFotos() {
        return (List<Foto>) repo.findAll();
    }

    @Override
    public void guardar(Foto foto) {
        repo.save(foto);
    }

    @Override
    public void eliminar(Foto foto) {
        repo.delete(foto);
    }

    @Override
    public Foto encontrarFoto(Foto foto) {
        return repo.findById(foto.getIdFoto()).orElse(null);
    }
    
}
