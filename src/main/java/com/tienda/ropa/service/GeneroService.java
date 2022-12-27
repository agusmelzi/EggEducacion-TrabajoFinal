package com.tienda.ropa.service;

import com.tienda.ropa.entities.Generos;
import java.util.List;

public interface GeneroService {
    
    public List<Generos> listarGeneros();
    
    public void guardar(Generos genero);
    
    public void eliminar(Generos genero);
    
    public Generos encontrarGenero(Generos genero);
}
