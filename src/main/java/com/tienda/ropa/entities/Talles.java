package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "talles")
public class Talles implements Serializable {
    
    private static final long serialVersionUID =6L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTalle;
    private String descripcion;
    @ManyToOne
    private Estados estado_talle;
}
