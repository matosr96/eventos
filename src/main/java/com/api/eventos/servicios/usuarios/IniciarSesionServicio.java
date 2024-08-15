package com.api.eventos.servicios.usuarios;

import com.api.eventos.dtos.LoginDto;
import com.api.eventos.entidades.Usuario;
import com.api.eventos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class IniciarSesionServicio {
    private static final Logger logger = LoggerFactory.getLogger(IniciarSesionServicio.class);
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public IniciarSesionServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario IniciarSesion(LoginDto loginDto) {
        String correo = loginDto.getCorreo();
        String contraseña = loginDto.getContraseña();

        logger.info("Iniciando sesión para el correo: {}", correo);

        // Busca el usuario por correo electrónico
        Optional<Usuario> usuarioOpt = usuarioRepositorio.findByCorreo(correo);

        logger.info("info encontrada: {}", usuarioOpt);

        if (!usuarioOpt.isPresent()) {
            logger.error("Usuario no encontrado para el correo: {}", correo);
            throw new IllegalArgumentException("Usuario no encontrado para el correo proporcionado.");
        }

        Usuario usuarioEncontrado = usuarioOpt.get();

        // Verifica si la contraseña es correcta
        if (contraseña.equals(usuarioEncontrado.getContraseña())) {
            logger.info("Usuario autenticado exitosamente: {}", usuarioEncontrado.getNombre());
            return usuarioEncontrado;
        } else {
            logger.error("Contraseña incorrecta para el usuario: {}", correo);
            throw new IllegalArgumentException("Contraseña incorrecta.");
        }
    }
}