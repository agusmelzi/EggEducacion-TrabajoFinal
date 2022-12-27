package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    
    private static final long serialVersionUID =9L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    @ManyToOne
    private Producto producto; // ?
    @ManyToOne
    private Colores color_producto;
    @ManyToOne
    private Talles talle_producto;
    private Integer stock_actual;
    private Integer punto_pedido; // ?
    private Double precio_min;
    private Double precio_may;
    private Integer porcentaje_desc;
    @ManyToOne
    private Foto foto1;
    @ManyToOne
    private Foto foto2;
    @ManyToOne
    private Foto foto3;
}
