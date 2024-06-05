package com.api.eventos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "asistentes")
@AllArgsConstructor
@NoArgsConstructor

public class Asistente {
    @Id
    private String id;
    private int identificacion;
    private String nombre;
    private String idEvento;
    private String estadoAsistencia;

}
