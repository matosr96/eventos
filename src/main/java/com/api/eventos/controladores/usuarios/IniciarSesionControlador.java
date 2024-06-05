package com.api.eventos.controladores.usuarios;

import com.api.eventos.dtos.LoginDto;
import com.api.eventos.entidades.Usuario;
import com.api.eventos.servicios.usuarios.IniciarSesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class IniciarSesionControlador {
    private IniciarSesionServicio iniciarSesionServicio;

    @Autowired
    public IniciarSesionControlador(IniciarSesionServicio iniciarSesionServicio) {
        this.iniciarSesionServicio = iniciarSesionServicio;
    }

    @PostMapping(value = "/iniciar-sesion", headers = "Accept=application/json")
    public ResponseEntity<?> iniciarSesionControlador(@RequestBody LoginDto loginDto) {
        try {
            Usuario usuarioLogueado = iniciarSesionServicio.IniciarSesion(loginDto);
            return new ResponseEntity<>(usuarioLogueado, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de iniciar sesion: " + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
