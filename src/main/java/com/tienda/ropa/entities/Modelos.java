package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "modelos")
public class Modelos implements Serializable {
    
    private static final long serialVersionUID =2L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModelo;
    private String descripcion;
    @ManyToOne
    private Estados estado_modelo;
}
