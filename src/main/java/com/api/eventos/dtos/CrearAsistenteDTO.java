package com.api.eventos.dtos;

import lombok.Data;

@Data
public class CrearAsistenteDTO {
    private int identificacion;
    private String nombre;
    private String idEvento;
    private String estadoAsistencia;


}
