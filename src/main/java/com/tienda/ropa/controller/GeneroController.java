package com.tienda.ropa.controller;

import com.tienda.ropa.entities.Generos;
import com.tienda.ropa.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genero")
public class GeneroController {
    
    @Autowired
    private GeneroService serv;
    
    @GetMapping("/listar")
    public String listarGeneros(Model model){
        List<Generos> generos = serv.listarGeneros();
        
        model.addAttribute("generos", generos);
        
        return "listaGeneros";
    }
    
    @GetMapping("/agregar")
    public String agregar(Generos genero){
        
        return "modificarGenero";
    }
    
    @PostMapping("/guardar")
    public String guardar(Generos genero){ // , Errors errores
//        if(errores.hasErrors()){
//            return "modificarModelo";
//        }
        serv.guardar(genero);
        return "redirect:/genero/listar";
    }
    
    @GetMapping("/editar/{idGenero}")
    public String editar(Generos genero, Model model){
        genero= serv.encontrarGenero(genero);
        model.addAttribute("modelo", genero);
        return "modificarGenero";
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Generos genero){
        serv.eliminar(genero);
        
        return "redirect:/genero/listar";
    }
    
}
