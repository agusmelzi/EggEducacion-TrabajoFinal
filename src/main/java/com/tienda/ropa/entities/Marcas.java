package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "marcas")
public class Marcas implements Serializable {
    
    private static final long serialVersionUID =4L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;
    private String descripcion;
    @ManyToOne
    private Estados estado_marca;
}
