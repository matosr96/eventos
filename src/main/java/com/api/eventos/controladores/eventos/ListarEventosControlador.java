package com.api.eventos.controladores.eventos;

import com.api.eventos.entidades.Evento;
import com.api.eventos.servicios.eventos.ListarEventosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ListarEventosControlador {
    private final ListarEventosServicio listarEventosServicio;

    @Autowired
    public ListarEventosControlador(ListarEventosServicio listarEventosServicio) {
        this.listarEventosServicio = listarEventosServicio;
    }

    @GetMapping(value = "/eventos", headers = "Accept=application/json")
    public ResponseEntity<?> listarEventosControlador() {
        try {
            List<Evento> listaEventosRetornada = listarEventosServicio.listarEventos();
            return new ResponseEntity<>(listaEventosRetornada, HttpStatus.OK);
        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de obtener los eventos: " + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
