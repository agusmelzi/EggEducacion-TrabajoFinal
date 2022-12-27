package com.tienda.ropa.usuario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data //crea los getters y los setters - para que funcione hay que cargar las dependencias en el POM
@Entity
@Table(name = "condicion_fiscal")
public class Condicion_fiscal implements Serializable {

    private static final long serialVersionUID =15L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcondicion_fiscal;

    private String nombre;
    private String abreviatura;
    private String discrimina;
    private String letra_factura;

}
