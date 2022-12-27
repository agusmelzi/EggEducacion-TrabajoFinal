
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
@Table(name = "identificacion")
public class Identificacion implements Serializable {
    
    private static final long serialVersionUID =19L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoident;
    
    private String abreviatura;
    private String descripcion;
    
  

/* NOTA: EL SIGUIENTE CODIGO SE GENERO AUTOMATICAMENTE CON UN METODO DISTINTO,
@Entity
public class Identificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tipoident;
    
    public Long getId() {
        return id_tipoident;
        
    }
    public void setId(Long id) {
        this.id_tipoident = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_tipoident != null ? id_tipoident.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_tipoident fields are not set
        if (!(object instanceof Identificacion)) {
            return false;
        }
        Identificacion other = (Identificacion) object;
        if ((this.id_tipoident == null && other.id_tipoident != null) || (this.id_tipoident != null && !this.id_tipoident.equals(other.id_tipoident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "store.entities.Identificacion[ id=" + id_tipoident + " ]";
    }
    */
}
