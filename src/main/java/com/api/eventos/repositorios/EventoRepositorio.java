package com.api.eventos.repositorios;

import com.api.eventos.entidades.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventoRepositorio extends MongoRepository<Evento,String> {
}
