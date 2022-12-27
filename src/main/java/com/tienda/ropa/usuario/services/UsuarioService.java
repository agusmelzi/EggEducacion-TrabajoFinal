package com.tienda.ropa.usuario.services;


import com.tienda.ropa.extras.ErrorServicio;
import com.tienda.ropa.usuario.FotoUsuario;
import com.tienda.ropa.usuario.Usuario;
import com.tienda.ropa.usuario.repositorios.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpSession;


/*
ACCIONES USUARIO
1 permitir que registrar su cuenta
    en los sitios web se le piden al usuario unos datos basicos para crear la cuenta, luego cuando realizan la compra se completan esos datos. ¿Como resolvemos esto?
    -Elegir los atributos que va a completar en la primera parte del proceso-

2 permitir modificar su cuenta
3 permitir que un usuario registrado ingrese y elimine su cuenta  
4 permitir que un usuario pueda habilitar nuevamente su cuenta
5 permitir que el usuario carge su foto en su cuenta  
 */
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /*ANEXAR FOTO AL REGISTRO:
    1-Generamos un vinculo entre el servicio de usaurio y el servicio de foto
    2-En el metodo regitrar, recibimos como parametros un archivo MultipartFile archivo
    3-Si el usuario decibe guardar la foto (puede no hacerlo), nuestro servicio de foto la guarda en la base de datos 
    4-al usuario, le ingreso la foto con un set
    
    
     */
    @Autowired
    private FotoUsuarioService fotoService; //1-Vinculo entre servicio usuario y foto

    @Transactional //2- recibimos como parametros un archivo MultipartFile archivo
    public Usuario registrar(MultipartFile archivo, String nombre, String apellido, String email, String password, String password2) throws Exception {
        validar(nombre, apellido, email, password, password2);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(encoder.encode(password));
        //usuario.setFecha_nacim(fecha_nacim); //Ver si esto esta bien  

        FotoUsuario foto = fotoService.guardar(archivo);//3-Si el usuario decibe guardar la foto, nuestro servicio de foto la guarda en la base de datos 
        usuario.setFoto(foto); //4-al usuario, le ingreso la foto con un set

        return usuarioRepositorio.save(usuario);
    }

    /*MODIFICAR FOTO:
   1-En el metodo modificar, recibimos como parametros un archivo MultipartFile archivo
   2-Obtenemos el id de la foto que tiene seteado ese usuario, Declaramos una variable de tipo string 
   3-preguntamos si el usuario tenia una foto guardada
   4- si tiene una foto guardada le pedimos el id de esa foto
   5-declaro una variable de tipo FotoUsuario, llamo al servicio de foto y a treves de él el método actualizar
   6-al usuario, le ingreso la foto con un set
     */
    //1-recibimos como parametros un archivo MultipartFile archivo

    @Transactional
    public Usuario modificar(MultipartFile archivo, Long idusuario, String nombre, String apellido, String email, String password, String password2, Date fecha_nacim) throws Exception {

        validar(nombre, apellido, email, password, password2);
        Optional<Usuario> respuesta = usuarioRepositorio.findById(idusuario);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            usuario.setPassword(password);
            //usuario.setFecha_nacim(fecha_nacim); //Ver si esto esta bien

            String idFoto = null; // 2-Obtenemos el id de la foto que tiene seteado ese usuario, Declaramos una variable de tipo string 
            if (usuario.getFoto() != null) {  //3-preguntamos si el usuario tenia una foto guardada
                idFoto = usuario.getFoto().getIdFoto(); //4- si tiene una foto guardada le pedimos el id de esa foto

            }
            FotoUsuario foto = fotoService.actualizar(idFoto, archivo);//5-declaro una variable de tipo FotoUsuario, llamo al servicio de foto y a treves de él el método actualizar

            usuario.setFoto(foto); //   6-al usuario, le ingreso la foto con un set
            usuarioRepositorio.save(usuario);

        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado");
        }
        return null;
    }

    @Transactional
    public Usuario deshabilitar(Long idusuario) throws Exception {

        Optional<Usuario> respuesta = usuarioRepositorio.findById(idusuario);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setBaja(new Date());

            usuarioRepositorio.save(usuario);

        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado");
        }
        return null;
    }

    @Transactional
    public Usuario habilitar(Long idusuario) throws Exception {

        Optional<Usuario> respuesta = usuarioRepositorio.findById(idusuario);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setBaja(null);

            usuarioRepositorio.save(usuario);

        } else {
            throw new ErrorServicio("No se encontró el usuario solicitado");

        }
        return null;
    }

    private void validar(String nombre, String apellido, String email, String password, String password2) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty() || nombre.length() < 3) {
            throw new ErrorServicio("El nombre del usuario no puede ser nulo y debe tener un mínimo de 3 caracteres");
        }

        if (apellido == null || apellido.isEmpty() || apellido.length() < 3) {
            throw new ErrorServicio("El apellido del usuario no puede ser nulo y debe tener un mínimo de 3 caracteres");
        }

        if (email == null || email.isEmpty()) {
            throw new ErrorServicio("El email del usuario no puede ser nulo");
        }

        if (password == null || password.isEmpty() || password.length() < 6) {
            throw new ErrorServicio("El password del usuario no puede ser nulo ni menor a 6 dígitos");
        }

        if (password2 == null || password2.isEmpty() || password2.length() < 6) {
            throw new ErrorServicio("El password del usuario no puede ser nulo ni menor a 6 dígitos");
        }

        if (!password2.equals(password)) {
            throw new ErrorServicio("Las contraseñas no coinciden, vuelva a ingresarlas");
        }
//        if (fecha_nacim == null) { //  ||fecha_nacim.LocalDate.now().plusYears(17) )
//            throw new ErrorServicio("La fecha de nacimiento no debe ser nula");
//        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
           Usuario usuarios = usuarioRepositorio.findByEmail(email);
            System.out.println("email"+ email);
            User user;
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession",usuarios);
            return new User(email,usuarios.getPassword(), authorities);
        } catch (Exception e) {
            throw new UsernameNotFoundException("El usuario no existe");
        }

    }

    /* https://www.youtube.com/watch?v=gCuaWpGMG4w&list=PLgwlfcqa5h3x8HAea7s3DXv5CvjEfR4uG&index=4    14:04 explica el metodo para desabilitar el usuario  */
}

//segundo video  https://www.youtube.com/watch?v=hMWNM6pT65s&list=PL3keVXHKb8g4bOTJ5aYVkoqaexlTuZNPM&index=3
//COMPLETAR LA CLASE SERVICIO 

