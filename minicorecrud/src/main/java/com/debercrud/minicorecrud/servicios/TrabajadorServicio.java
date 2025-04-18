package com.debercrud.minicorecrud.servicios;

import com.debercrud.minicorecrud.modelos.Trabajador;

import java.util.List;

public interface TrabajadorServicio {
    public List<Trabajador> ListarTrabajadores();

    public Trabajador GuardarTrabajador(Trabajador trabajador);

    public Trabajador EncontrarTrabajadorPorID(Long id);

    public Trabajador actualizarTrabajador(Trabajador trabajador);
}
