package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Tarea;
import com.debercrud.minicorecrud.repositorios.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServicioImplem implements TareaServicio{

    @Autowired
    private TareaRepositorio repositorio;


    @Override
    public Tarea GuardarTarea(Tarea tarea) {
        return repositorio.save(tarea);
    }
}
