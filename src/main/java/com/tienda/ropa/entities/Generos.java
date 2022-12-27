package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "generos")
public class Generos implements Serializable {
   
    private static final long serialVersionUID = 3L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;
    private String descripcion;
    @ManyToOne
    private Estados estado_genero;
}
