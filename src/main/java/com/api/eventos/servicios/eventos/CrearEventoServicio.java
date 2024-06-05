package com.api.eventos.servicios.eventos;

import com.api.eventos.dtos.CrearEventoDTO;
import com.api.eventos.entidades.Evento;
import com.api.eventos.repositorios.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearEventoServicio {
    private final EventoRepositorio eventoRepositorio;

    @Autowired
    public CrearEventoServicio(EventoRepositorio eventoRepositorio){
        this.eventoRepositorio=eventoRepositorio;
    }

    public Evento crearEvento(CrearEventoDTO crearEventoDTO){
        Evento evento = new Evento();

        evento.setNombre(crearEventoDTO.getNombre());
        evento.setDescripcion(crearEventoDTO.getDescripcion());
        evento.setFechaInicio(crearEventoDTO.getFechaInicio());
        evento.setFechaFin(crearEventoDTO.getFechaFin());
        evento.setUbicacion(crearEventoDTO.getUbicacion());
        evento.setOrganizador(crearEventoDTO.getOrganizador());
        evento.setAsistentes(crearEventoDTO.getAsistentes());
        evento.setCapacidadMaxima(crearEventoDTO.getCapacidadMaxima());

        return eventoRepositorio.save(evento);
    }
}
