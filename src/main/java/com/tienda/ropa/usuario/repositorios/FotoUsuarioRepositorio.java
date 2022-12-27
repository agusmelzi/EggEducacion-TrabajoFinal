
package com.tienda.ropa.usuario.repositorios;

import com.tienda.ropa.usuario.FotoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FotoUsuarioRepositorio extends JpaRepository <FotoUsuario, String > {
    
}
