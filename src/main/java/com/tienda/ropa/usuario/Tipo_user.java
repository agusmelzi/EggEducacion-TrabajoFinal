package com.tienda.ropa.usuario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_user")
public class Tipo_user implements Serializable {

    private static final long serialVersionUID =20L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipo_user;
    
    private String descripcion;
    private String actualiza_producto;
    private String actualiza_stock;
    private String genera_pedido;
    private String actualiza_atributos;
    
}
