package com.tienda.ropa.controller;

import com.tienda.ropa.entities.Colores;
import com.tienda.ropa.service.ColorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/color")
public class ColorController {
    
    @Autowired
    private ColorService serv;
    
    @Autowired
    private EstadoController est;
    
    @GetMapping("/listar")
    public String listarColores(Model model){
        List<Colores> colores = serv.listarColores();
        
        model.addAttribute("colores", colores);
        
        return "listaColores";
    }
    
    @GetMapping("/agregar")
    public String agregar(Colores color, Model model){
        model.addAttribute("color", color);
        listarColores(model);
        est.listarEstados(model);
        return "modificarColor";
    }
    
    @PostMapping("/guardar")
    public String guardar(Colores color){ // , Errors errores
//        if(errores.hasErrors()){
//            return "modificarModelo";
//        }
        serv.guardar(color);
        return "redirect:/color/agregar";
    }
    
    @GetMapping("/editar/{idColor}")
    public String editar(Colores color, Model model){
        color= serv.encontrarColores(color);
        model.addAttribute("color", color);
        listarColores(model);
        est.listarEstados(model);
        return "modificarColor";
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Colores color){
        serv.eliminar(color);
        
        return "redirect:/color/agregar";
    }
}
