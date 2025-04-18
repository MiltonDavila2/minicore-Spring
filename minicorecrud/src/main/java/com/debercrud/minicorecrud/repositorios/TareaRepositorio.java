package com.debercrud.minicorecrud.repositorios;

import com.debercrud.minicorecrud.modelos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea,Long> {
    @Query("SELECT t FROM Tarea t WHERE t.fechaf >= :fechaMin AND t.fechai <= :fechaMax")
    List<Tarea> filtrarPorRangoFechas(@Param("fechaMin") LocalDate fechaMin,
                                      @Param("fechaMax") LocalDate fechaMax);
}
