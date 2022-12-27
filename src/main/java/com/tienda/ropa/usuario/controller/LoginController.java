package com.tienda.ropa.usuario.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String login(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String email){
        if (error != null){
            System.out.println("No se encontro");
            model.addAttribute("error","El email o la contraseña son incorrectos");
        }
        if ( email != null){
            model.addAttribute("email",email);
        }
        return "redirect:/";
    }
 @GetMapping("/logout")
    public String logout (Model model){
        model.addAttribute("success","Sesion Finalizada" );
        return "index";
 }
}
