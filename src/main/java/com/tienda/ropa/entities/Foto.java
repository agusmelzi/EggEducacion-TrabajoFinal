package com.tienda.ropa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "foto")
public class Foto implements Serializable {
    
    private static final long serialVersionUID =8L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoto;

    private String nombre;
    private String mime; //asigna el formato del archivo de la foto. Cuando el navegador pide la foto le devolvemos en las cabeceras que tipo de  mime es el archivo que estamos devolviendo, para que el navegador lo interprete correctamente. 

    @Lob //indica que el tipo de datos es pesado. 
    @Basic(fetch = FetchType.LAZY) //indica que cargue el contenido solo cuando lo pidamos, hace que sea mas liviano
    private byte[] contenido;
}
