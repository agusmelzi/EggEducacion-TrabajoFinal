
package com.tienda.ropa.usuario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "localidad")
public class Localidad implements Serializable {
    
    private static final long serialVersionUID =21L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlocalidad;
    private String nombre;
    
    @OneToOne
    private Provincia provincia_id;
}
