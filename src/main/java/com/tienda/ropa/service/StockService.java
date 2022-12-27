package com.tienda.ropa.service;

import com.tienda.ropa.entities.Stock;
import java.util.List;

public interface StockService {
    
    public List<Stock> listarTodo();
    
    public List<Stock> listarStockPorGenero(Long id);
    
    public List<Stock> listarModelosHombres(Long idModelo);
    
    public List<Stock> listarModelosMujeres(Long idModelo);
    
    public List<Stock> listarModelosKids(Long idModelo);
    
    public List<Stock> listarTallesHombres(Long idTalle);
    
    public List<Stock> listarTallesMujeres(Long idTalle);
    
    public List<Stock> listarTallesKids(Long idTalle);
    
    public List<Stock> listarMarcasHombres(Long idMarca);
    
    public List<Stock> listarMarcasMujeres(Long idMarca);
    
    public List<Stock> listarMarcasKids(Long idMarca);
    
    public List<Stock> listarColoresHombres(Long idColor);
    
    public List<Stock> listarColoresMujeres(Long idColor);
    
    public List<Stock> listarColoresKids(Long idColor);
    
    public void guardar(Stock stock);
    
    public void eliminar(Stock stock);
    
    public Stock encontrarStock(Stock stock);
}
