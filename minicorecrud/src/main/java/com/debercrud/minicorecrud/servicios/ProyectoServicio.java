package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Proyecto;

import java.util.List;

public interface ProyectoServicio {

    public Proyecto GuardarProyecto(Proyecto proyecto);

    public Proyecto ObtenerProyectoId(Long id);

    public List<Proyecto> ListarProyectos();
}
