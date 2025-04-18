package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Proyecto;
import com.debercrud.minicorecrud.repositorios.ProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServicioImplem implements ProyectoServicio{
    @Autowired
    private ProyectoRepositorio repositorio;

    @Override
    public Proyecto GuardarProyecto(Proyecto proyecto) {
        return repositorio.save(proyecto);
    }

    @Override
    public Proyecto ObtenerProyectoId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Proyecto> ListarProyectos() {
        return repositorio.findAll();
    }
}
