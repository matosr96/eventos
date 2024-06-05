package com.api.eventos.servicios.Asistentes;

import com.api.eventos.entidades.Asistente;
import com.api.eventos.repositorios.AsistenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EliminarAsistenteServicio{
    private final AsistenteRepositorio asistenteRepositorio;

    @Autowired

    public  EliminarAsistenteServicio (AsistenteRepositorio asistenteRepositorio) {
        this.asistenteRepositorio = asistenteRepositorio;
        }
    public boolean eliminarAsistente(String id) {
        Optional<Asistente> asistenteOptional = asistenteRepositorio.findById(id);

        if (asistenteOptional.isPresent()) {
            asistenteRepositorio.delete(asistenteOptional.get());

            return true;
        }else{
            return false;
        }
    }
}