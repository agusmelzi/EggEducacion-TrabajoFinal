package com.tienda.ropa.controller;

import com.tienda.ropa.entities.Talles;
import com.tienda.ropa.service.TalleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/talle")
public class TalleController {
    
    @Autowired
    private TalleService serv;
    
    @Autowired
    private EstadoController est;
    
    @GetMapping("/listar")
    public String listarTalles(Model model){
        List<Talles> talles = serv.listarTalles();
        
        model.addAttribute("talles", talles);
        
        return "listaTalles";
    }
    
    @GetMapping("/agregar")
    public String agregar(Talles talle, Model model){
        model.addAttribute("talle", talle);
        listarTalles(model);
        est.listarEstados(model);
        return "modificarTalle";
    }
    
    @PostMapping("/guardar")
    public String guardar(Talles talle){ // , Errors errores
//        if(errores.hasErrors()){
//            return "modificarModelo";
//        }
        serv.guardar(talle);
        return "redirect:/talle/agregar";
    }
    
    @GetMapping("/editar/{idTalle}")
    public String editar(Talles talle, Model model){
        talle= serv.encontrarTalles(talle);
        model.addAttribute("talle", talle);
        listarTalles(model);
        return "modificarTalle";
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Talles talle){
        serv.eliminar(talle);
        
        return "redirect:/talle/agregar";
    }
}
