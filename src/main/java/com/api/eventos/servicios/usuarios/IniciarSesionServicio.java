package com.api.eventos.servicios.usuarios;

import com.api.eventos.dtos.LoginDto; // Importa la clase LoginDto que contiene los datos de inicio de sesión.
import com.api.eventos.entidades.Usuario; // Importa la entidad Usuario.
import com.api.eventos.repositorios.UsuarioRepositorio; // Importa el repositorio de Usuario.
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired para la inyección de dependencias.
import org.springframework.stereotype.Service; // Importa la anotación Service para definir un servicio.
import org.slf4j.Logger; // Importa la clase Logger para el registro de logs.
import org.slf4j.LoggerFactory; // Importa la clase LoggerFactory para crear instancias de Logger.

import java.util.List; // Importa la clase List para manejar colecciones de usuarios.

@Service // Define esta clase como un servicio de Spring.
public class IniciarSesionServicio {
    private static final Logger logger = LoggerFactory.getLogger(IniciarSesionServicio.class); // Crea un Logger para el registro de información.
    private UsuarioRepositorio usuarioRepositorio; // Declara el repositorio de usuarios.

    @Autowired // Inyección de dependencias del repositorio de usuarios.
    public IniciarSesionServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio; // Asigna el repositorio inyectado a la variable local.
    }

    // Método para iniciar sesión que recibe un LoginDto y puede lanzar una excepción IllegalAccessException.
    public Usuario IniciarSesion(LoginDto loginDto) {
        String correo = loginDto.getCorreo(); // Obtiene el correo del DTO de inicio de sesión.
        String contraseña = loginDto.getContraseña(); // Obtiene la contraseña del DTO de inicio de sesión.
        Usuario usuarioEncontrado = null; // Inicializa la variable para almacenar el usuario encontrado.

        logger.info("Iniciando sesión para el correo: {}", correo); // Registra un mensaje de inicio de sesión.

        // Obtiene todos los usuarios de la base de datos y los guarda en una lista de usuarios.
        List<Usuario> listaDeUsuarios = usuarioRepositorio.findAll();

        // Itera sobre la lista de usuarios para encontrar el usuario con el correo dado.
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getCorreo().equals(correo)) { // Compara el correo del usuario actual con el correo dado.
                usuarioEncontrado = usuario; // Si coincide, asigna el usuario encontrado a la variable.
                break; // Sale del bucle ya que el usuario ha sido encontrado.
            }
        }

        if (usuarioEncontrado != null) { // Verifica si se encontró un usuario con el correo dado.
            if (contraseña.equals(usuarioEncontrado.getContraseña())) { // Verifica si la contraseña coincide.
                logger.info("Usuario encontrado y contraseña correcta"); // Registra un mensaje indicando que la contraseña es correcta.
            } else {
                logger.error("Contraseña incorrecta para el usuario: {}", correo); // Registra un mensaje de error indicando que la contraseña es incorrecta.
            }
        }

        // Si el usuario no se encuentra
        logger.error("Usuario no encontrado para el correo: {}", correo); // Registra un mensaje de error indicando que no se encontró el usuario.
        return usuarioEncontrado;
    }
}
