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


		// Crear Trabajadores
		Trabajador t1 = new Trabajador("Milton", "Davila");
		Trabajador t2 = new Trabajador("Andrea", "Lopez");
		Trabajador t3 = new Trabajador("Carlos", "Martinez");

		servicioTrabajador.GuardarTrabajador(t1);
		servicioTrabajador.GuardarTrabajador(t2);
		servicioTrabajador.GuardarTrabajador(t3);

		// Crear Proyectos
		Proyecto p1 = new Proyecto("Banco Pichincha");
		Proyecto p2 = new Proyecto("Core Systems");
		Proyecto p3 = new Proyecto("App Móvil");

		proyectoServicio.GuardarProyecto(p1);
		proyectoServicio.GuardarProyecto(p2);
		proyectoServicio.GuardarProyecto(p3);

		// Tareas con fechas pasadas
		tareaServicio.GuardarTarea(new Tarea("Tarea pasada 1", 8, true, t1, p1,
				LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 20)));

		tareaServicio.GuardarTarea(new Tarea("Tarea pasada 2", 5, false, t2, p2,
				LocalDate.of(2025, 1, 5), LocalDate.of(2025, 2, 10)));

		tareaServicio.GuardarTarea(new Tarea("Tarea pasada 3", 6, true, t3, p3,
				LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 25)));

		// Tareas en curso
		tareaServicio.GuardarTarea(new Tarea("Tarea actual 1", 4, true, t1, p2,
				LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 25)));

		tareaServicio.GuardarTarea(new Tarea("Tarea actual 2", 3, false, t2, p3,
				LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 30)));

		// Tareas futuras
		tareaServicio.GuardarTarea(new Tarea("Tarea futura 1", 7, true, t3, p1,
				LocalDate.of(2025, 5, 5), LocalDate.of(2025, 5, 20)));

		tareaServicio.GuardarTarea(new Tarea("Tarea futura 2", 9, false, t1, p3,
				LocalDate.of(2025, 6, 1), LocalDate.of(2025, 6, 15)));
	}
}

