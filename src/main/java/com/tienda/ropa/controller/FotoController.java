package com.tienda.ropa.controller;


import com.tienda.ropa.entities.Foto;
import com.tienda.ropa.repository.FotoRepo;
import com.tienda.ropa.service.FotoService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/foto")
public class FotoController {
    
    @Autowired
    private FotoService serv;
    
    @Autowired
    private FotoRepo repo;
    
//    @GetMapping("/agregar")
//    public String form(Model model){
//        model.addAttribute("producto", new Foto());
//        return "modificarFoto";
//    }
    
    @GetMapping("/agregar")
    public String form(Foto foto, Model model){
        listar(model);
        return "modificarFoto";
    }
    
    @PostMapping("/guardar")
    public String guardar(@RequestParam(name = "file", required = false) MultipartFile archivo) throws IOException{
        
        Foto foto = new Foto();
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        foto.setContenido(archivo.getBytes());
        
        serv.guardar(foto);
        //flash.addFlashAttribute("success", "Foto subida");
        
        return "redirect:/foto/agregar";
    }
    
    public Foto guardarFotoProducto(@RequestParam(name = "file", required = false) MultipartFile archivo) throws IOException{
        
        Foto foto = new Foto();
        foto.setNombre(archivo.getOriginalFilename());
        foto.setMime(archivo.getContentType());
        foto.setContenido(archivo.getBytes());
        
        serv.guardar(foto);
        //flash.addFlashAttribute("success", "Foto subida");
        
        return foto;
    }
    
    @GetMapping("/listar")
    public String listar(Model model){
        
        model.addAttribute("fotos", serv.listarFotos());
        
        return "listarFotos";
    }
    
    @GetMapping("/buscarFoto/{idFoto}")
    public ResponseEntity<byte[]> buscarPorId(@PathVariable Long idFoto){ 
        
        Foto foto = repo.findById(idFoto).orElse(null);
        byte[] img = foto.getContenido();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        
        return new ResponseEntity<>(img, headers, HttpStatus.OK);
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Foto foto){
        serv.eliminar(foto);
        
        return "redirect:/foto/agregar";
    }
}
