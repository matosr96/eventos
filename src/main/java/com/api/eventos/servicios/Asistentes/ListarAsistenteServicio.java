package com.api.eventos.servicios.Asistentes;

import com.api.eventos.entidades.Asistente;
import com.api.eventos.repositorios.AsistenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarAsistenteServicio {

private final AsistenteRepositorio asistenteRepositorio;

@Autowired
    public ListarAsistenteServicio(AsistenteRepositorio asistenteRepositorio) {
    this.asistenteRepositorio = asistenteRepositorio;
    }
    public List<Asistente> listarAsistentes(){
        return asistenteRepositorio.findAll();
}
}
