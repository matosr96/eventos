package com.api.eventos.controladores.asistentes;

import com.api.eventos.dtos.ActualizarAsistenteDTO;
import com.api.eventos.entidades.Asistente;
import com.api.eventos.servicios.Asistentes.ActualizarAsistenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ActualizarAsistenteControlador {
    private final ActualizarAsistenteServicio actualizarAsistenteServicio;

    @Autowired
    public ActualizarAsistenteControlador (ActualizarAsistenteServicio actualizarAsistenteServicio) {
        this.actualizarAsistenteServicio = actualizarAsistenteServicio;
    }
    @PutMapping(value =  "/asistentes", headers = "Accept=application/json")
    public ResponseEntity <?> actualizarAsistente(@RequestBody ActualizarAsistenteDTO actualizarAsistenteDTO) {
        try {
            Asistente asistenteActualizado = actualizarAsistenteServicio.actualizarAsistente(actualizarAsistenteDTO);
            return new ResponseEntity<>(asistenteActualizado,HttpStatus.OK);

        } catch (Exception exception){
            String mensajeDeError = "Hubo un error al tratar de actualizar el asistente" + exception.getMessage();
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}

