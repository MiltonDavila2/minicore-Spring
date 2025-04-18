package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Trabajador;
import com.debercrud.minicorecrud.repositorios.TrabajadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServicioImplem implements TrabajadorServicio{

    @Autowired
    private TrabajadorRepositorio repositorio;


    @Override
    public List<Trabajador> ListarTrabajadores() {
        return repositorio.findAll();
    }

    @Override
    public Trabajador GuardarTrabajador(Trabajador trabajador) {
        return repositorio.save(trabajador);
    }

    @Override
    public Trabajador EncontrarTrabajadorPorID(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajador) {
        return repositorio.save(trabajador);
    }
}
