package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "colores")
public class Colores implements Serializable {
    
    private static final long serialVersionUID =5L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColor;
    private String nombre_color;
    @ManyToOne
    private Estados estado_color;
}
