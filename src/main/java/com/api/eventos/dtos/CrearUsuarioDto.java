package com.api.eventos.dtos;

import lombok.Data;

@Data
public class CrearUsuarioDto {
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String rol;
}
