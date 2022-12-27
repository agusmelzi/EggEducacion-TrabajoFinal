package com.tienda.ropa.service;

import com.tienda.ropa.entities.Foto;
import java.util.List;

public interface FotoService {
    
    public List<Foto> listarFotos();
    
    public void guardar(Foto foto);
    
    public void eliminar(Foto foto);
    
    public Foto encontrarFoto(Foto foto);
}
