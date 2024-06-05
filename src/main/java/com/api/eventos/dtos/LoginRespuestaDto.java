package com.api.eventos.dtos;

import com.api.eventos.entidades.Usuario;

public class LoginRespuestaDto {
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private Usuario usuario;
}
