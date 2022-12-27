package com.tienda.ropa.service;

import com.tienda.ropa.entities.Material;
import java.util.List;

public interface MaterialService {
    
    public List<Material> listarMateriales();
    
    public void guardar(Material material);
    
    public void eliminar(Material material);
    
    public Material encontrarMateriales(Material material);
}
