package com.api.eventos.repositorios;

import com.api.eventos.entidades.Usuario;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositorio extends MongoRepository<Usuario,String> {
    Optional<Usuario> findByCorreo(String correo);

    Boolean existsByCorreo(String correo);
}
