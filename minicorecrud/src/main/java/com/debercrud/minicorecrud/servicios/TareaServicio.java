package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Tarea;

import java.util.List;

public interface TareaServicio {
    public Tarea GuardarTarea(Tarea tarea);
    public List<Tarea> ListarTareas();
    public Tarea ObtenerTareaPorId(Long id);
}
