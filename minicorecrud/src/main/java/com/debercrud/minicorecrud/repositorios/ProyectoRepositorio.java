package com.debercrud.minicorecrud.repositorios;

import com.debercrud.minicorecrud.modelos.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepositorio extends JpaRepository<Proyecto,Long> {
}
