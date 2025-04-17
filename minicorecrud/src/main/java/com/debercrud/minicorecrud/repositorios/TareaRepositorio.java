package com.debercrud.minicorecrud.repositorios;

import com.debercrud.minicorecrud.modelos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea,Long> {
}
