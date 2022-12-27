package com.tienda.ropa.controller;


import com.tienda.ropa.entities.Modelos;
import com.tienda.ropa.repository.ModeloRepositorio;
import com.tienda.ropa.service.ModeloService;

import java.util.List;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelo")
public class ModeloControlador {
    
    @Autowired
    private ModeloService serv;
    
    @Autowired
    private EstadoController est;
    
    @GetMapping("/listar")
    public String listarModelos(Model model){
        List<Modelos> modelos = serv.listarModelos();
        
        model.addAttribute("modelos", modelos);
        
        return "listaModelos";
    }
    
    @GetMapping("/agregar")
    public String agregar(Modelos modelo, Model model){
        model.addAttribute("modelo", modelo);
        listarModelos(model);
        est.listarEstados(model);
        return "modificarModelo";
    }
    
    @PostMapping("/guardar")
    public String guardar(Modelos modelo){ // , Errors errores
//        if(errores.hasErrors()){
//            return "modificarModelo";
//        }
        serv.guardar(modelo);
        return "redirect:/modelo/agregar"; //
    }
    
    @GetMapping("/editar/{idModelo}")
    public String editar(Modelos modelo, Model model){
        modelo= serv.encontrarModelos(modelo);
        model.addAttribute("modelo", modelo);
        listarModelos(model);
        est.listarEstados(model);
        return "modificarModelo";
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Modelos modelo){
        serv.eliminar(modelo);
        
        return "redirect:/modelo/agregar";
    }
}
