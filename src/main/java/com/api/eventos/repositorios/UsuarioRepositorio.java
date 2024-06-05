package com.api.eventos.repositorios;

import com.api.eventos.entidades.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositorio extends MongoRepository<Usuario,String> {
}
