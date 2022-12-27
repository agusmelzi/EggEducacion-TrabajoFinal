package com.tienda.ropa.usuario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

@Data //crea los getters y los setters
@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {

    private static final long serialVersionUID =17L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdministrador;

    private String nombreAdmin;
    private String apellidoAdmin;
    private String dniAdmin;
    private String email;
    private long numeroTelefono;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAltaAdmin;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaBajaAdmin;
    private String contraseniaAdmin;
    
    @OneToOne
    private FotoUsuario foto;
    
//con que otras clases se relaciona el Administrador?
    /*     Uno a uno con la clase foto
           
    
    */
}
