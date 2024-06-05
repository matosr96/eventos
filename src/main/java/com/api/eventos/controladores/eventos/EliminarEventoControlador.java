package com.api.eventos.controladores.eventos;

import com.api.eventos.servicios.eventos.EliminarEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EliminarEventoControlador {
    private final EliminarEventoServicio eliminarEventoServicio;

    @Autowired
    public EliminarEventoControlador(EliminarEventoServicio eliminarEventoServicio) {
        this.eliminarEventoServicio = eliminarEventoServicio;
    }

    @DeleteMapping(value = "/eventos/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> eliminarEvento(@PathVariable("id") String id) {
        try {
            boolean respuesta = eliminarEventoServicio.eliminarEvento(id);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de eliminar el evento: " + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
