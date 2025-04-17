package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Proyecto;

public interface ProyectoServicio {

    public Proyecto GuardarProyecto(Proyecto proyecto);

    public Proyecto ObtenerProyectoId(Long id);
}
