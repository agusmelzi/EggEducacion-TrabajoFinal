
package com.tienda.ropa.usuario.repositorios;

import com.tienda.ropa.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {

//    @Query(value = "SELECT email FROM usuario WHERE email = ?",nativeQuery = true)
//    Usuario findByemail(String var);

    Usuario findByEmail(String email);
}
