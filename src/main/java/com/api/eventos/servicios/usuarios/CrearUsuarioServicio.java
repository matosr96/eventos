package com.api.eventos.servicios.usuarios; // Define el paquete donde se encuentra esta clase.

import com.api.eventos.dtos.CrearUsuarioDto; // Importa la clase CrearUsuarioDto que contiene los datos para crear un nuevo usuario.
import com.api.eventos.entidades.Usuario; // Importa la entidad Usuario.
import com.api.eventos.repositorios.UsuarioRepositorio; // Importa el repositorio de Usuario.
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired para la inyección de dependencias.
import org.springframework.stereotype.Service; // Importa la anotación Service para definir un servicio.

@Service // Define esta clase como un servicio de Spring.
public class CrearUsuarioServicio {
    private final UsuarioRepositorio usuariorepositorio; // Declara el repositorio de usuarios.
    
    @Autowired // Inyección de dependencias del repositorio de usuarios.
    public CrearUsuarioServicio(UsuarioRepositorio usuariorepositorio) {
        this.usuariorepositorio = usuariorepositorio; // Asigna el repositorio inyectado a la variable local.
    }

    // Método para crear un usuario que recibe un CrearUsuarioDto y retorna un Usuario.
    public Usuario crearUsuario(CrearUsuarioDto crearusuariodto) {
        Usuario usuario = new Usuario(); // Crea una nueva instancia de Usuario.
        usuario.setNombre(crearusuariodto.getNombre()); // Asigna el nombre del usuario desde el DTO.
        usuario.setApellido(crearusuariodto.getApellido()); // Asigna el apellido del usuario desde el DTO.
        usuario.setCorreo(crearusuariodto.getCorreo()); // Asigna el correo del usuario desde el DTO.
        usuario.setRol(crearusuariodto.getRol()); // Asigna el rol del usuario desde el DTO.
        usuario.setContraseña(crearusuariodto.getContraseña()); // Asigna la contraseña del usuario desde el DTO.

        // El repositorio interactúa con la base de datos y crea el usuario.
        // Esta línea regresa la información del usuario creado.
        return usuariorepositorio.save(usuario);
    }
}
