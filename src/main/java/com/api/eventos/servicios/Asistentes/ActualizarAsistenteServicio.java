package com.api.eventos.servicios.Asistentes;

import com.api.eventos.dtos.ActualizarAsistenteDTO;
import com.api.eventos.entidades.Asistente;
import com.api.eventos.repositorios.AsistenteRepositorio;
import com.api.eventos.servicios.eventos.ActualizarEventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ActualizarAsistenteServicio {

    private final AsistenteRepositorio asistenteRepositorio;

    @Autowired
    public ActualizarAsistenteServicio(AsistenteRepositorio asistenteRepositorio) {
        this.asistenteRepositorio = asistenteRepositorio;
    }
    public Asistente actualizarAsistente(ActualizarAsistenteDTO actualizarAsistenteDTO){
        List<Asistente> listaDeAsistentes = asistenteRepositorio.findAll();
        Asistente asistenteEncontrado = null;

        for (Asistente asistente : listaDeAsistentes) {
            if (asistente.getId().equals(actualizarAsistenteDTO.getId())) {
                asistenteEncontrado = asistente;
                break;
            }
        }
        if (asistenteEncontrado != null) {
            asistenteEncontrado.setIdentificacion(actualizarAsistenteDTO.getIdentificacion());
            asistenteEncontrado.setNombre(actualizarAsistenteDTO.getNombre());
            asistenteEncontrado.setIdEvento(actualizarAsistenteDTO.getIdEvento());
            asistenteEncontrado.setEstadoAsistencia(actualizarAsistenteDTO.getEstadoAsistencia());
            return asistenteRepositorio.save(asistenteEncontrado);
        } else {
            return null;
        }
    }
}
