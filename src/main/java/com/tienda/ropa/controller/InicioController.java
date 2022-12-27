package com.tienda.ropa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    
    @Autowired
    private ModeloControlador mod;
    
    @GetMapping("/")
    public String incio(Model model){
        mod.listarModelos(model);
        return "index";
    }
    
    @GetMapping("/pagos")
    public String pagos(Model model){
        mod.listarModelos(model);
        return "linkPagos";
    }
    
    @GetMapping("/envio")
    public String envio(Model model){
        mod.listarModelos(model);
        return "linkEnvio";
    }
    
    @GetMapping("/cambio")
    public String cambio(Model model){
        mod.listarModelos(model);
        return "linkCambios";
    }
}
