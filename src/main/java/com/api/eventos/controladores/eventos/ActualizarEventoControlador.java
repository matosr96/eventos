package com.api.eventos.controladores.eventos;

import com.api.eventos.dtos.ActualizarEventoDTO;
import com.api.eventos.entidades.Evento;
import com.api.eventos.servicios.eventos.ActualizarEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ActualizarEventoControlador {
    private final ActualizarEventoServicio actualizarEventoServicio;

    @Autowired
    public ActualizarEventoControlador(ActualizarEventoServicio actualizarEventoServicio) {
        this.actualizarEventoServicio = actualizarEventoServicio;
    }

    @PutMapping(value = "/eventos", headers = "Accept=application/json")
    public ResponseEntity<?> actualizarEvento(@RequestBody ActualizarEventoDTO actualizarEventoDTO) {
        try {
            Evento eventoActualizado = actualizarEventoServicio.actualizarEvento(actualizarEventoDTO);
            return new ResponseEntity<>(eventoActualizado, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de actualizar el evento: " + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
