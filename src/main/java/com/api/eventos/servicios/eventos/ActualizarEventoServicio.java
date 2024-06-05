package com.api.eventos.servicios.eventos;

import com.api.eventos.dtos.ActualizarEventoDTO;
import com.api.eventos.entidades.Evento;
import com.api.eventos.repositorios.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualizarEventoServicio {

    private final EventoRepositorio eventoRepositorio;

    @Autowired
    public ActualizarEventoServicio(EventoRepositorio eventoRepositorio){
        this.eventoRepositorio = eventoRepositorio;
    }

    public Evento actualizarEvento(ActualizarEventoDTO actualizarEventoDTO){
        List<Evento> listaDeEventos = eventoRepositorio.findAll();
        Evento eventoEncontrado = null;

        for(Evento evento : listaDeEventos){
            if(evento.getId().equals(actualizarEventoDTO.getId())){
                eventoEncontrado = evento;
                break;
            }
        }

        if(eventoEncontrado != null){
            eventoEncontrado.setNombre(actualizarEventoDTO.getNombre());
            eventoEncontrado.setDescripcion(actualizarEventoDTO.getDescripcion());
            eventoEncontrado.setFechaInicio(actualizarEventoDTO.getFechaInicio());
            eventoEncontrado.setFechaFin(actualizarEventoDTO.getFechaFin());
            eventoEncontrado.setUbicacion(actualizarEventoDTO.getUbicacion());
            eventoEncontrado.setOrganizador(actualizarEventoDTO.getOrganizador());
            eventoEncontrado.setAsistentes(actualizarEventoDTO.getAsistentes());
            eventoEncontrado.setCapacidadMaxima(actualizarEventoDTO.getCapacidadMaxima());

            return eventoRepositorio.save(eventoEncontrado);
        }else{
            return null;
        }
    }
}
