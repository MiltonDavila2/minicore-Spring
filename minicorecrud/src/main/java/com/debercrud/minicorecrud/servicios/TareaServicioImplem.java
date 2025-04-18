package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Tarea;
import com.debercrud.minicorecrud.repositorios.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TareaServicioImplem implements TareaServicio{

    @Autowired
    private TareaRepositorio repositorio;


    @Override
    public Tarea GuardarTarea(Tarea tarea) {
        return repositorio.save(tarea);
    }

    @Override
    public List<Tarea> ListarTareas() {
        return repositorio.findAll();
    }

    @Override
    public Tarea ObtenerTareaPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Tarea> BuscarPorRangoFechas(LocalDate fechaMin, LocalDate fechaMax) {
        return repositorio.filtrarPorRangoFechas(fechaMin,fechaMax);
    }
}
