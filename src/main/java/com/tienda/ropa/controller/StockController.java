package com.tienda.ropa.controller;

import com.tienda.ropa.entities.Foto;
import com.tienda.ropa.entities.Producto;
import com.tienda.ropa.entities.Stock;
import com.tienda.ropa.repository.FotoRepo;
import com.tienda.ropa.service.ColorService;
import com.tienda.ropa.service.ProductoService;
import com.tienda.ropa.service.StockService;
import com.tienda.ropa.service.TalleService;
import java.io.IOException;
import java.util.List;
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
@RequestMapping("/stock")
public class StockController {
    
    @Autowired
    private StockService serv;
    
    @Autowired
    private ProductoController prod;
    
    @Autowired
    private ColorController col;
    
    @Autowired
    private TalleController talle;
    
    @Autowired
    private ModeloControlador mod;
    
    @Autowired
    private MarcaController marca;
    
    @Autowired
    private FotoController foto;
    @Autowired
    private FotoRepo repo;
    
    @GetMapping("/listar")
    public String listarStock(Model model){
        List<Stock> stocks = (List<Stock>) serv.listarTodo();
        
        model.addAttribute("stocks", stocks);
        
        return "listaStocks";
    }
    
    @GetMapping("/listarPorGenero/{id}")
    public String listarPorGenero(@PathVariable Long id, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarStockPorGenero(id);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        if (id == 1) {
            return "productosHombre";
        } else if(id == 2){
            return "productosMujer";
        }else{
            return "productosKid";
        }
        
        
    }
    
    @GetMapping("/listarModelosHombres/{idModelo}")
    public String listarModelosHombres(@PathVariable Long idModelo, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarModelosHombres(idModelo);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosHombre";
    }
    
    @GetMapping("/listarModelosMujeres/{idModelo}")
    public String listarModelosMujeres(@PathVariable Long idModelo, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarModelosMujeres(idModelo);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosMujer";
    }
    
    @GetMapping("/listarModelosKids/{idModelo}")
    public String listarModelosKids(@PathVariable Long idModelo, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarModelosKids(idModelo);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosKid";
    }
    
    @GetMapping("/filtroTallesHombre/{idTalle}")
    public String filtroTallesHombre(@PathVariable Long idTalle, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarTallesHombres(idTalle);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosHombre";
    }
    
    @GetMapping("/filtroTallesMujer/{idTalle}")
    public String filtroTallesMujer(@PathVariable Long idTalle, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarTallesMujeres(idTalle);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosMujer";
    }
    
    @GetMapping("/filtroTallesKid/{idTalle}")
    public String filtroTallesKid(@PathVariable Long idTalle, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarTallesKids(idTalle);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosKid";
    }
    
    @GetMapping("/filtroMarcasHombre/{idMarca}")
    public String filtroMarcasHombre(@PathVariable Long idMarca, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarMarcasHombres(idMarca);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosHombre";
    }
    
    @GetMapping("/filtroMarcasMujer/{idMarca}")
    public String filtroMarcasMujer(@PathVariable Long idMarca, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarMarcasMujeres(idMarca);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosMujer";
    }
    
    @GetMapping("/filtroMarcasKid/{idMarca}")
    public String filtroMarcasKid(@PathVariable Long idMarca, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarMarcasKids(idMarca);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosKid";
    }
    
    @GetMapping("/filtroColorHombre/{idColor}")
    public String filtroColorHombre(@PathVariable Long idColor, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarColoresHombres(idColor);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosHombre";
    }
    
    @GetMapping("/filtroColorMujer/{idColor}")
    public String filtroColorMujer(@PathVariable Long idColor, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarColoresMujeres(idColor);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosMujer";
    }
    
    @GetMapping("/filtroColorKid/{idColor}")
    public String filtroColorKid(@PathVariable Long idColor, Model model){
        List<Stock> stocks = (List<Stock>) serv.listarColoresKids(idColor);
        
        model.addAttribute("stocks", stocks);
        mod.listarModelos(model);
        talle.listarTalles(model);
        marca.listarMarcas(model);
        col.listarColores(model);
        return "productosKid";
    }
    
    @GetMapping("/agregar")
    public String agregar(Stock stock, Model model){
        col.listarColores(model);
        talle.listarTalles(model);
        prod.listarProductos(model);
        listarStock(model);
//        mod.listarModelos(model);
//        marc.listarMarcas(model);
//        gen.listarGeneros(model);
//        mate.listarMateriales(model);
//        est.listarMarcas(model);
        return "modificarStock";
    }
    
    @PostMapping("/guardar")
    public String guardarModificacion(Stock stock){ // @Valid y Errors
        stock.setFoto1(stock.getProducto().getFoto1());
        stock.setFoto2(stock.getProducto().getFoto2());
        stock.setFoto3(stock.getProducto().getFoto3());
        stock.setPrecio_min(stock.getProducto().getPrecio());
        serv.guardar(stock);
        return "redirect:/stock/agregar";
    }
    
    @GetMapping("/editar/{idStock}")
    public String editar(Stock stock, Model model){
        stock= serv.encontrarStock(stock);
        model.addAttribute("stock", stock);
        col.listarColores(model);
        talle.listarTalles(model);
        prod.listarProductos(model);
        listarStock(model);
        return "modificarStock";
    }
    
     @GetMapping("/eliminar") // /{idProducto}") lo agrego si no es por query parameter
    public String eliminar(Stock stock){
        serv.eliminar(stock);
        
        return "redirect:/stock/agregar";
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
