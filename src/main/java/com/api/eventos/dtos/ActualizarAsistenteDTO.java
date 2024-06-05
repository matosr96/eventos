package com.api.eventos.dtos;

import lombok.Data;

@Data
public class ActualizarAsistenteDTO {

    private String id;
    private int identificacion;
    private String nombre;
    private String idEvento;
    private String estadoAsistencia;
}
