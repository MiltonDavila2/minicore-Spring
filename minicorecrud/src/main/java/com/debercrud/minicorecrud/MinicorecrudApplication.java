package com.debercrud.minicorecrud;

import com.debercrud.minicorecrud.modelos.Proyecto;
import com.debercrud.minicorecrud.modelos.Tarea;
import com.debercrud.minicorecrud.modelos.Trabajador;
import com.debercrud.minicorecrud.servicios.ProyectoServicio;
import com.debercrud.minicorecrud.servicios.TareaServicio;
import com.debercrud.minicorecrud.servicios.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MinicorecrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MinicorecrudApplication.class, args);
	}

	@Autowired
	TrabajadorServicio servicioTrabajador;
	@Autowired
	ProyectoServicio proyectoServicio;
	@Autowired
	TareaServicio tareaServicio;
	@Override
	public void run(String... args) throws Exception {


		Trabajador trabajador = new Trabajador("Milton", "Davila");

		servicioTrabajador.GuardarTrabajador(trabajador);

		Proyecto proyecto = new Proyecto("Banco Pichincha");

		proyectoServicio.GuardarProyecto(proyecto);

		Trabajador trabajador_para_tarea = servicioTrabajador.EncontrarTrabajadorPorID(1L);

		Proyecto proyecto_para_tarea = proyectoServicio.ObtenerProyectoId(1L);

		LocalDate fechainicio = LocalDate.of(2025,1,29);
		LocalDate fechafinal = LocalDate.now().plusDays(7);

		Tarea tarea = new Tarea("Proyecto Banco Pichincha",10,true,trabajador_para_tarea,proyecto_para_tarea, fechainicio,fechafinal);

		tareaServicio.GuardarTarea(tarea);
	}
}
