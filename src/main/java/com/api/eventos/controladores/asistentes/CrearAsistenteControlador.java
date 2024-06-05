package com.api.eventos.controladores.asistentes;

import com.api.eventos.dtos.CrearAsistenteDTO;
import com.api.eventos.entidades.Asistente;
import com.api.eventos.servicios.Asistentes.CrearAsistenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CrearAsistenteControlador {
    private final CrearAsistenteServicio crearAsistenteServicio;

    @Autowired
    public CrearAsistenteControlador (CrearAsistenteServicio crearAsistenteServicio) {
        this.crearAsistenteServicio = crearAsistenteServicio;
    }
    @PostMapping(value = "/asistentes" , headers = "Accept=application/json")
    public ResponseEntity <?> crearAsistente(@RequestBody CrearAsistenteDTO crearAsistenteDTO) {
        try {
            Asistente asistenteCreado = crearAsistenteServicio.crearAsistente(crearAsistenteDTO);
            return new ResponseEntity<>(asistenteCreado, HttpStatus.CREATED);

        } catch (Exception exception) {
            String mensajeDeError = "Hubo un error al tratar de crear el asistente :" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }
}
