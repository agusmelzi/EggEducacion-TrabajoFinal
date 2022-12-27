package com.tienda.ropa.service;


import com.tienda.ropa.entities.Modelos;
import java.util.List;


public interface ModeloService {
    
    public List<Modelos> listarModelos();
    
    public void guardar(Modelos modelo);
    
    public void eliminar(Modelos modelo);
    
    public Modelos encontrarModelos(Modelos modelo);
}
