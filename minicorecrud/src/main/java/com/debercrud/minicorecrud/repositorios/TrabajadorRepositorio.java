package com.debercrud.minicorecrud.repositorios;

import com.debercrud.minicorecrud.modelos.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepositorio extends JpaRepository<Trabajador,Long> {
}
