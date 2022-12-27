package com.tienda.ropa.service;

import com.tienda.ropa.entities.Material;
import com.tienda.ropa.repository.MaterialRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepositorio repo;
    
    @Override
    public List<Material> listarMateriales() {
        return (List<Material>) repo.findAll();
    }

    @Override
    public void guardar(Material material) {
        repo.save(material);
    }

    @Override
    public void eliminar(Material material) {
        repo.delete(material);
    }

    @Override
    public Material encontrarMateriales(Material material) {
        return repo.findById(material.getIdMaterial()).orElse(null);
    }
    
}
