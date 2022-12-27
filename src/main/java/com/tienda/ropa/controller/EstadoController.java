package com.tienda.ropa.controller;

import com.tienda.ropa.entities.Estados;
import com.tienda.ropa.repository.EstadoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estado")
public class EstadoController {
    
    @Autowired
    private EstadoRepositorio repo;
    
    @GetMapping("/listar")
    public String listarEstados(Model model){
        List<Estados> estados = (List<Estados>) repo.findAll();
        
        model.addAttribute("estados", estados);
        
        return null;
    }
}
