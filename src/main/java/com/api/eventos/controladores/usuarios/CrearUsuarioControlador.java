package com.api.eventos.controladores.usuarios;

import com.api.eventos.dtos.CrearUsuarioDto;
import com.api.eventos.entidades.Usuario;
import com.api.eventos.servicios.usuarios.CrearUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class CrearUsuarioControlador {
    private CrearUsuarioServicio crearUsuarioServicio;

    @Autowired
    public CrearUsuarioControlador (CrearUsuarioServicio crearUsuarioServicio) {
        this.crearUsuarioServicio = crearUsuarioServicio;
    }
    @PostMapping(value = "/crear-usuario",headers = "Accept=application/json")
    public ResponseEntity<?> crearUsuarioControlador(@RequestBody CrearUsuarioDto crearUsuarioDto) {
        try {
            Usuario usuarioCreado = crearUsuarioServicio.crearUsuario(crearUsuarioDto);
            return new ResponseEntity<>(usuarioCreado,HttpStatus.OK );
        } catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de crear el usuario" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError,HttpStatus.INTERNAL_SERVER_ERROR );

        }
    }

}
