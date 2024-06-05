package com.api.eventos.controladores.eventos;

import com.api.eventos.dtos.CrearEventoDTO;
import com.api.eventos.entidades.Evento;
import com.api.eventos.servicios.eventos.CrearEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/api/v1/eventos   requestBody

// POST => CREAR
// PUT => EDITAR
// DELETE => ELIMINAR
// GET => OBTENER

// HTTP STATUS
// 400 - 404 => LAS RUTAS NO SE ENCUENTRAN => REVISAR SI LA RUTA DE LA PETICION ESTA BIEN ESCRITA
// 500 - 503 => PROBLEMAS INTERNOS DE LA API - MANDE UNA PETICION Y NO TUVE RESPUESTA => (SERVICIOS)
// 200 - 202 => CUANDO TODO SALIO BIEN

@RestController
@RequestMapping("/api/v1")
public class CrearEventoControlador {
    private final CrearEventoServicio crearEventoServicio;

    @Autowired
    public CrearEventoControlador(CrearEventoServicio crearEventoServicio) {
        this.crearEventoServicio = crearEventoServicio;
    }

    @PostMapping(value = "/eventos", headers = "Accept=application/json")
    public ResponseEntity<?> crearEvento(@RequestBody CrearEventoDTO crearEventoDTO) {
        try {
            Evento eventoCreado = crearEventoServicio.crearEvento(crearEventoDTO);
            return new ResponseEntity<>(eventoCreado, HttpStatus.CREATED);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de crear el evento: " + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

// http://localhost:5000/api/v1/evento




