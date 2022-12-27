package com.tienda.ropa.usuario.controller;

import com.tienda.ropa.usuario.Usuario;
import com.tienda.ropa.usuario.services.UsuarioService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registroUsuario")
    public String registroUsuario(Usuario usuario) {
        return "registroUsuario";
    }

    @PostMapping("/registrar")
    public String registrar(ModelMap modelo, MultipartFile archivo, @RequestParam(required = false) String nombre, @RequestParam String apellido, @RequestParam String email, @RequestParam String password, @RequestParam String password2) {
        
        try {
            usuarioService.registrar(archivo, nombre, apellido, email, password, password2);
        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("email", email);
            //modelo.put("archivo", archivo);
            modelo.put("password", password);
            modelo.put("password2", password2);

            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return "registroUsuario.html";
        }
//        modelo.put("titulo", "Bienvenido a Moll´s, tu tienda Online");
//        modelo.put("descripcion", "¡Tu usuario fue registrado con éxito!");

        return "redirect:/";
    }
}
/*


package store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {
    
    @GetMapping ("/")
    public String index() {
        return "index.html";
    }
}

 */
