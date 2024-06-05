package com.api.eventos.repositorios;

import com.api.eventos.entidades.Asistente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsistenteRepositorio extends MongoRepository<Asistente,String> {
}