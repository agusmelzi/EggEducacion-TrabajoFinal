package com.tienda.ropa.controller;


import com.tienda.ropa.entities.Foto;
import com.tienda.ropa.entities.Producto;
import com.tienda.ropa.entities.Stock;
import com.tienda.ropa.repository.FotoRepo;
import com.tienda.ropa.repository.ProductoRepository;
import com.tienda.ropa.service.ProductoService;
import com.tienda.ropa.service.StockService;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService serv;
    
    @Autowired
    private ModeloControlador mod;
    
    @Autowired
    private MarcaController marc;
    
    @Autowired
    private GeneroController gen;
    
    @Autowired
    private MaterialController mate;
    
    @Autowired
    private EstadoController est;
    
    @Autowired
    private StockService stock;
    
    @Autowired
    private FotoController foto;
    
    @Autowired
    private FotoRepo repo;
    
    @GetMapping("/productos")
    public String vistaProductos(){
        return "productos";
    }
    
    @GetMapping("/listar")
    public String listarProductos(Model model){
        List<Producto> productos = (List<Producto>) serv.listarProuctos();
        mod.listarModelos(model);
        model.addAttribute("productos", productos);
        
        return "listaProductos";
    }
    
    @GetMapping("/listarMujeres")
    public String listarMujeres(Model model){
        List<Producto> productos = (List<Producto>) serv.listarProuctosMujer();
        
        model.addAttribute("productos", productos);
        
        return "productos";
    }
    
    @GetMapping("/listarHombres")
    public String listarHombres(Model model){
        List<Producto> productos = (List<Producto>) serv.listarProuctosHombre();
        
        model.addAttribute("productos", productos);
        
        return "productos";
    }
    
    @GetMapping("/listarPantalonesHombres")
    public String listarPantalonesHombres(Model model){
        List<Producto> productos = (List<Producto>) serv.listarPantalonesHombre();
        
        model.addAttribute("productos", productos);
        
        return "productos";
    }
    
    @GetMapping("/listarKids")
    public String listarKids(Model model){
        List<Producto> productos = (List<Producto>) serv.listarProuctosKids();
        
        model.addAttribute("productos", productos);
        
        return "productos";
    }
    
    @GetMapping("/listarConFotos")
    public String listarFotosProductos(Model model){
        List<Producto> productos = (List<Producto>) serv.listarProuctos();
        
        model.addAttribute("productos", productos);
        
        return "productos";
    }
    
    @GetMapping("/agregar")
    public String agregar(Producto producto, Model model){
        mod.listarModelos(model);
        marc.listarMarcas(model);
        gen.listarGeneros(model);
        mate.listarMateriales(model);
        est.listarEstados(model);
        foto.listar(model);
        return "modificarProducto";
    }
    
    @PostMapping("/guardar")
    public String guardar(Producto producto) {
        
        serv.guardar(producto);
        return "redirect:/producto/listar";
    }
    
    @PostMapping("/guardarMod")
    public String guardarModificacion(Producto producto){ // @Valid y Errors

        serv.guardar(producto);
        return "redirect:/producto/listar";
    }
    
    @GetMapping("/editar/{idProducto}")
    public String editar(Producto producto, Model model){
        producto= serv.encontrarProducto(producto);
        model.addAttribute("producto", producto);
        mod.listarModelos(model);
        marc.listarMarcas(model);
        gen.listarGeneros(model);
        mate.listarMateriales(model);
        est.listarEstados(model);
        foto.listar(model);
        return "modificarProducto";
    }
    
    @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Producto producto){
        ArrayList<Stock> stocks = (ArrayList<Stock>) stock.listarTodo();

        for (Stock st : stocks) {
            if (producto.getIdProducto() == st.getProducto().getIdProducto()) {
                stock.eliminar(st);
            }
        }
        serv.eliminar(producto);
        
        return "redirect:/producto/listar";
    }
    
    @GetMapping("/buscarFoto/{idFoto}")
    public ResponseEntity<byte[]> buscarPorId(@PathVariable Long idFoto){ 
        
        Foto foto = repo.findById(idFoto).orElse(null);
        byte[] img = foto.getContenido();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        
        return new ResponseEntity<>(img, headers, HttpStatus.OK);
    }
}
