package com.tienda.ropa.controller;

import com.tienda.ropa.entities.Material;
import com.tienda.ropa.service.MaterialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/material")
public class MaterialController {
    
    @Autowired
    private MaterialService serv;
    
    @GetMapping("/listar")
    public String listarMateriales(Model model){
        List<Material> materiales = serv.listarMateriales();
        
        model.addAttribute("materiales", materiales);
        
        return "listaMateriales";
    }
    
    @GetMapping("/agregar")
    public String agregar(Material material, Model model){
        model.addAttribute("material", material);
        listarMateriales(model);
        
        return "modificarMaterial";
    }
    
    @PostMapping("/guardar")
    public String guardar(Material material){ // , Errors errores
//        if(errores.hasErrors()){
//            return "modificarModelo";
//        }
        serv.guardar(material);
        return "redirect:/material/agregar";
    }
    
    @GetMapping("/editar/{idMaterial}")
    public String editar(Material material, Model model){
        material= serv.encontrarMateriales(material);
        model.addAttribute("material", material);
        listarMateriales(model);
        return "modificarMaterial";
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Material material){
        serv.eliminar(material);
        
        return "redirect:/material/agregar";
    }
}
