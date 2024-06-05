package com.api.eventos.servicios.Asistentes;

import com.api.eventos.dtos.CrearAsistenteDTO;
import com.api.eventos.entidades.Asistente;
import com.api.eventos.repositorios.AsistenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearAsistenteServicio {
    private final AsistenteRepositorio asistenteRepositorio;

    @Autowired
    public CrearAsistenteServicio(AsistenteRepositorio asistenteRepositorio){
        this.asistenteRepositorio = asistenteRepositorio;
    }
    public Asistente crearAsistente (CrearAsistenteDTO crearAsistenteDTO) {
        Asistente asistente = new Asistente();

        asistente.setIdentificacion(crearAsistenteDTO.getIdentificacion());
        asistente.setNombre(crearAsistenteDTO.getNombre());
        asistente.setIdEvento(crearAsistenteDTO.getIdEvento());
        asistente.setEstadoAsistencia(crearAsistenteDTO.getEstadoAsistencia());

        return asistenteRepositorio.save(asistente);

    }
}
