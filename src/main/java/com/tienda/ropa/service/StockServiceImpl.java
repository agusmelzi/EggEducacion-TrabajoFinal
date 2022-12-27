package com.tienda.ropa.service;

import com.tienda.ropa.entities.Stock;
import com.tienda.ropa.repository.StockRepositorio;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    
    @Autowired
    private StockRepositorio repo;
    
    @Override
    public List<Stock> listarTodo() {
        return (List<Stock>) repo.listarTodo();
    }
    
    @Override
    public List<Stock> listarStockPorGenero(Long id) {
        return (List<Stock>) repo.buscarPorGenero(id);
    }
    
    @Override
    public List<Stock> listarModelosHombres(Long idModelo) {
        return (List<Stock>) repo.buscarModelosHombres(idModelo);
    }
    
    @Override
    public List<Stock> listarModelosMujeres(Long idModelo) {
        return (List<Stock>) repo.buscarModelosMujeres(idModelo);
    }
    
    @Override
    public List<Stock> listarModelosKids(Long idModelo) {
        return (List<Stock>) repo.buscarModelosKids(idModelo);
    }
    
    @Override
    public List<Stock> listarTallesHombres(Long idTalle) {
        return (List<Stock>) repo.buscarTallesHombres(idTalle);
    }
    
    @Override
    public List<Stock> listarTallesMujeres(Long idTalle) {
        return (List<Stock>) repo.buscarTallesMujeres(idTalle);
    }
    
    @Override
    public List<Stock> listarTallesKids(Long idTalle) {
        return (List<Stock>) repo.buscarTallesKids(idTalle);
    }
    
    @Override
    public List<Stock> listarMarcasHombres(Long idMarca) {
        return (List<Stock>) repo.buscarMarcasHombres(idMarca);
    }
    
    @Override
    public List<Stock> listarMarcasMujeres(Long idMarca) {
        return (List<Stock>) repo.buscarMarcasMujeres(idMarca);
    }
    
    @Override
    public List<Stock> listarMarcasKids(Long idMarca) {
        return (List<Stock>) repo.buscarMarcasKids(idMarca);
    }
    
    @Override
    public List<Stock> listarColoresHombres(Long idColor) {
        return (List<Stock>) repo.buscarColoresHombres(idColor);
    }
    
    @Override
    public List<Stock> listarColoresMujeres(Long idColor) {
        return (List<Stock>) repo.buscarColoresMujeres(idColor);
    }
    
    @Override
    public List<Stock> listarColoresKids(Long idColor) {
        return (List<Stock>) repo.buscarColoresKids(idColor);
    }
    
    @Override
    public void guardar(Stock stock) {
        repo.save(stock);
    }

    @Override
    public void eliminar(Stock stock) {
        repo.delete(stock);
    }

    @Override
    public Stock encontrarStock(Stock stock) {
        return repo.findById(stock.getIdStock()).orElse(null);
    }
}
