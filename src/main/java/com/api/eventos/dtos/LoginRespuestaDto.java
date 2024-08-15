package com.api.eventos.dtos;

import com.api.eventos.entidades.Usuario;

public class LoginRespuestaDto {
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
