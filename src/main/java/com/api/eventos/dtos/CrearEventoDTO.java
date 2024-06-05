package com.api.eventos.dtos;

import lombok.Data;

@Data
public class CrearEventoDTO {
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String ubicacion;
    private String organizador;
    private String[] asistentes;
    private int capacidadMaxima;
}
