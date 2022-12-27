package com.tienda.ropa.service;

import com.tienda.ropa.entities.Marcas;
import java.util.List;

public interface MarcaService {
    
    public List<Marcas> listarMarcas();
    
    public void guardar(Marcas marca);
    
    public void eliminar(Marcas marca);
    
    public Marcas encontrarMarcas(Marcas marca);
}
