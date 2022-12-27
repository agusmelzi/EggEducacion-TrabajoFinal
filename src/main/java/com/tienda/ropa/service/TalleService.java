package com.tienda.ropa.service;

import com.tienda.ropa.entities.Talles;
import java.util.List;

public interface TalleService {
    
    public List<Talles> listarTalles();
    
    public void guardar(Talles talle);
    
    public void eliminar(Talles talle);
    
    public Talles encontrarTalles(Talles talle);
}
