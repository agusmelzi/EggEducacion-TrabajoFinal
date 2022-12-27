package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID =7L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String descripcion;
    private String descripcion_corta;
    private Double precio;
    @ManyToOne
    private Material material_producto;
    @ManyToOne
    private Modelos modelo_producto;
    @ManyToOne
    private Estados estado_producto;
    @ManyToOne
    private Marcas marca_producto;
    @ManyToOne
    private Generos genero_producto;
    @ManyToOne
    private Foto foto1;
    @ManyToOne
    private Foto foto2;
    @ManyToOne
    private Foto foto3;
    
    //private Colores color_producto; //preguntar si va o no
    private Boolean destacado;
}
