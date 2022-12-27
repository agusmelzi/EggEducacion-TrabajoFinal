package com.tienda.ropa.service;

import com.tienda.ropa.entities.Colores;
import java.util.List;

public interface ColorService {
    
    public List<Colores> listarColores();
    
    public void guardar(Colores color);
    
    public void eliminar(Colores color);
    
    public Colores encontrarColores(Colores color);
}
