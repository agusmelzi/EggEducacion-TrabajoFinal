package com.tienda.ropa.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data //crea los getters y los setters - para que funcione hay que cargar las dependencias en el POM
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID =13L;// chequear si funciona sin esto

    /*@OneToMany(mappedBy = "idusuario")
    private List<Condicion_fiscal> condicion_fiscals; */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private String razon_social;
    @OneToOne
    private Identificacion tipo_ident;
    
    private String identificacion;
    
    @OneToOne
    private Condicion_fiscal tipo_fiscal; //
    @OneToOne
    private Calle calle;//
    
    private int numero;
    
    @OneToOne
    private Provincia provincia;//
    
    @OneToOne
    private Localidad localidad;//
    
    private String piso;
    private String departamento;
    private String notas_domicilio;
    private String codigopostal;
    private String telefono;
    private String celular;

    @OneToOne
    private Calle callefac;//
    
    private int numerofac;
    
    @OneToOne
    private Provincia provinciafac;//
    @OneToOne
    private Localidad localidadfac;//
    
    private String pisofac;
    private String departamentofac;
    private String codigopostalfac;
    private String notas_domiciliofac;
    
    @OneToOne // o OneToMany??
    private Tipo_user tipouser;//
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date fecha_nacim;
    private String estado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_ult_estado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date baja;
   
    @OneToOne //ManyToOne - OneToMany
    private FotoUsuario foto;
}
