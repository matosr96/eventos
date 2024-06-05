package com.api.eventos.controladores.asistentes;

import com.api.eventos.entidades.Asistente;
import com.api.eventos.servicios.Asistentes.ListarAsistenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ListarAsistenteControlador {
    private final ListarAsistenteServicio listarAsistenteServicio;

    @Autowired
    public ListarAsistenteControlador(ListarAsistenteServicio listarAsistenteServicio){
        this.listarAsistenteServicio= listarAsistenteServicio;

    }
    @GetMapping(value = "/asistentes", headers = "Accept=application/json")
    public ResponseEntity<?> listarAsistenteControlador(){
        try {
            List<Asistente> listaAsistenteRetornada = listarAsistenteServicio.listarAsistentes();
            return new ResponseEntity<>(listaAsistenteRetornada, HttpStatus.OK );
        } catch (Exception exception) {
            String mensajedeError = "Hubo un error al tratar de obtener los asistente" + exception.getMessage();
            return new ResponseEntity<>(mensajedeError,HttpStatus.INTERNAL_SERVER_ERROR );


        }
    }
}
