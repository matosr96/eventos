package com.api.eventos.controladores.asistentes;

import com.api.eventos.servicios.Asistentes.EliminarAsistenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EliminarAsistenteControlador {
    private final EliminarAsistenteServicio eliminarAsistenteServicio;

    @Autowired
    public EliminarAsistenteControlador(EliminarAsistenteServicio eliminarAsistenteServicio){
        this.eliminarAsistenteServicio = eliminarAsistenteServicio;
    }
@DeleteMapping(value = "/asistentes/{id}" , headers = "Accept=application/json")
    public ResponseEntity<?> eliminarAsistente(@PathVariable("id") String id){
 try {
     boolean respuesta = eliminarAsistenteServicio.eliminarAsistente(id);
     return new ResponseEntity<>(respuesta , HttpStatus.OK);
 } catch (Exception exception) {
     String mensajeDeError = "Hubo un error al tratar de eliminar el asistente" + exception.getMessage();
     return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);

 }
}

}
