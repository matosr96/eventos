package com.api.eventos.servicios.eventos;

import com.api.eventos.entidades.Evento;
import com.api.eventos.repositorios.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarEventosServicio {
    private final EventoRepositorio eventoRepositorio;

    @Autowired
    public ListarEventosServicio(EventoRepositorio eventoRepositorio){
        this.eventoRepositorio = eventoRepositorio;
    }

    public List<Evento> listarEventos(){
        return eventoRepositorio.findAll();
    }
}
