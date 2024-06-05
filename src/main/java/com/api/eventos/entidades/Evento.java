package com.api.eventos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "eventos")
public class Evento {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String ubicacion;
    private String organizador;
    private String[] asistentes;
    private int capacidadMaxima;

}
