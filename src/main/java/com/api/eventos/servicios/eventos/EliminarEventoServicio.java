package com.api.eventos.servicios.eventos;

import com.api.eventos.entidades.Evento;
import com.api.eventos.repositorios.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EliminarEventoServicio {
    private final EventoRepositorio eventoRepositorio;

    @Autowired
    public EliminarEventoServicio(EventoRepositorio eventoRepositorio) {
        this.eventoRepositorio = eventoRepositorio;
    }

    public boolean eliminarEvento(String id) {
        Optional<Evento> eventoOptional = eventoRepositorio.findById(id);

        if (eventoOptional.isPresent()) {
            eventoRepositorio.delete(eventoOptional.get());
            return true;
        } else {
            return false;
        }
    }
}
