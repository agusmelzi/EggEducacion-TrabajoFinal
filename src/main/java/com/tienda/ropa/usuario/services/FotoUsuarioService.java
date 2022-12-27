package com.tienda.ropa.usuario.services;


import com.tienda.ropa.extras.ErrorServicio;
import com.tienda.ropa.usuario.FotoUsuario;
import com.tienda.ropa.usuario.repositorios.FotoUsuarioRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FotoUsuarioService {

    @Autowired //3-marcamos con la anotacion Autowired para inyectar las dependencias 
    private FotoUsuarioRepositorio fotoRepositorio; //2-importamos el repositorio para persistir 

    //1-metodo para GUARDAR FOTO
    @Transactional //modifica la base de datos
    public FotoUsuario guardar(MultipartFile archivo) throws ErrorServicio { //el metodo recibe un archico MultipartFile es el archivo donde se almacena el archivo de la foto 
        if (archivo != null) { //si el archivo es distinto a nulo, voy a procesar el archivo y...
            try { //4-creamos un try para manejar la excepcion
                FotoUsuario foto = new FotoUsuario(); //creamos entidad de foto
                foto.setMime(archivo.getContentType());//seteamos el archivo mime de la foto
                foto.setNombre(archivo.getName()); //seteamos el nombre de la foto
                foto.setContenido(archivo.getBytes()); //Esta lectura puede generar un error, por ello creamos un bloque try para atrapar la excepcion por si la lectura del archivo falla

                return fotoRepositorio.save(foto); //si esta todo bien, devuelve la foto persistida
            } catch (Exception e) {
                System.err.println(e.getMessage()); //si ocurre el error lo imprimo en consola para analizarlo
            }
        }
        return null;
    }

    //metodo para ACTUALIZAR FOTO  1-copiamos parte de la estructura del metodo anterior
    @Transactional
    public FotoUsuario actualizar(String idFoto, MultipartFile archivo) throws ErrorServicio {

        if (archivo != null) { //si el archivo es nullo devuelve un null (linea final)
            try {
                FotoUsuario foto = new FotoUsuario();// 2-creamos una variable de tipo foto y la inicializamos
                if (idFoto != null) { // 3-si el usuario tiene una foto asignada, debo buscar la foto 
                    Optional<FotoUsuario> respuesta = fotoRepositorio.findById(idFoto); //4-para buscar la foto uso Optional, llamamos al repositorio de foto, con el metodo findById pasamos el id de la foto  
                    if (respuesta.isPresent()) { //5-si existe en la base de datos una foto con ese id 
                        foto = respuesta.get();//6- a la variable foto la piso con lo que traigo de la base de datos 
                    }
                }
                foto.setMime(archivo.getContentType()); //7- luego modifico los datos de la foto, el tipo mime, 
                foto.setNombre(archivo.getName());//                                              el nombre
                foto.setContenido(archivo.getBytes()); //                                         el nuevo contenido

                return fotoRepositorio.save(foto); //8- actualizo la foto y retorno la foto actualizada y persistida en la base de datos  
            } catch (Exception e) {
                System.err.println(e.getMessage()); //si ocurre el error lo imprimo en consola para analizarlo
            }
        }
        return null;
    }

    //Ahora vinculamos la foto al servicio de Administrador y al servicio de Usuario. 
    //https://www.youtube.com/watch?v=AowVsh6opDg&list=PL3keVXHKb8g4bOTJ5aYVkoqaexlTuZNPM   
    // ---
}
