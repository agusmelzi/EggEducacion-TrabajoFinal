package com.tienda.ropa.controller;

import com.tienda.ropa.entities.Marcas;
import com.tienda.ropa.service.MarcaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marca")
public class MarcaController {
    
    @Autowired
    private MarcaService serv;
    
    @Autowired
    private EstadoController est;
    
    @GetMapping("/listar")
    public String listarMarcas(Model model){
        List<Marcas> marcas = serv.listarMarcas();
        
        model.addAttribute("marcas", marcas);
        
        return "listaMarcas";
    }
    
    @GetMapping("/agregar")
    public String agregar(Marcas marca, Model model){
        model.addAttribute("marca", marca);
        listarMarcas(model);
        est.listarEstados(model);
        return "modificarMarca";
    }
    
    @PostMapping("/guardar")
    public String guardar(Marcas marca){ // , Errors errores
//        if(errores.hasErrors()){
//            return "modificarModelo";
//        }
        serv.guardar(marca);
        return "redirect:/marca/agregar";
    }
    
    @GetMapping("/editar/{idMarca}")
    public String editar(Marcas marca, Model model){
        marca= serv.encontrarMarcas(marca);
        model.addAttribute("marca", marca);
        listarMarcas(model);
        est.listarEstados(model);
        return "modificarMarca";
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Marcas marca){
        serv.eliminar(marca);
        
        return "redirect:/marca/agregar";
    }
}
