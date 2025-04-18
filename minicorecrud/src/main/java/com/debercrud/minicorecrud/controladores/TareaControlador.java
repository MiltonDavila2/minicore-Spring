package com.debercrud.minicorecrud.controladores;

import com.debercrud.minicorecrud.modelos.Proyecto;
import com.debercrud.minicorecrud.modelos.Tarea;
import com.debercrud.minicorecrud.modelos.Trabajador;
import com.debercrud.minicorecrud.servicios.ProyectoServicio;
import com.debercrud.minicorecrud.servicios.TareaServicio;
import com.debercrud.minicorecrud.servicios.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TareaControlador {

    @Autowired
    private ProyectoServicio proyectoServicio;
    @Autowired
    private TareaServicio servicio;
    @Autowired
    private TrabajadorServicio trabajadorServicio;

    @GetMapping("/tareas")
    public String listarTareas(Model modelo){
        modelo.addAttribute("tareas", servicio.ListarTareas());
        return "tareas";
    }

    @GetMapping("/tareas/nuevo")
    public String MostrarFormularioCrearTarea(Model modelo){
        Tarea tarea = new Tarea();

        modelo.addAttribute("tarea", tarea);
        modelo.addAttribute("proyectos",proyectoServicio.ListarProyectos());
        modelo.addAttribute("trabajadores",trabajadorServicio.ListarTrabajadores());

        return "crear_tarea";
    }

    @PostMapping("/tareas")
    public String guardarTarea(@ModelAttribute("tarea") Tarea tarea, @RequestParam("proyectoId") Long proyectoId,
                               @RequestParam("trabajadorId") Long trabajadorId) {

        Proyecto proyecto = proyectoServicio.ObtenerProyectoId(proyectoId);

        Trabajador trabajador = trabajadorServicio.EncontrarTrabajadorPorID(trabajadorId);


        tarea.setProyecto(proyecto);
        tarea.setTrabajador(trabajador);

        servicio.GuardarTarea(tarea);


        return "redirect:/tareas";
    }


    @GetMapping("/tareas/editar/{id}")
    public String FormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("tarea",servicio.ObtenerTareaPorId(id));
        modelo.addAttribute("proyectos",proyectoServicio.ListarProyectos());
        modelo.addAttribute("trabajadores",trabajadorServicio.ListarTrabajadores());
        return "editar_tarea";
    }

    @PostMapping("/tareas/{id}")
    public String GuardarEditado(@PathVariable Long id, @ModelAttribute("tarea") Tarea tarea, @RequestParam("proyectoId") Long ProyectoId,
                                 @RequestParam("trabajadorId") Long TrabajadorId,Model Modelo){

        Tarea tareaQueyahabia = servicio.ObtenerTareaPorId(id);

        Proyecto proyecto = proyectoServicio.ObtenerProyectoId(ProyectoId);

        Trabajador trabajador = trabajadorServicio.EncontrarTrabajadorPorID(TrabajadorId);


        tareaQueyahabia.setId(id);
        tareaQueyahabia.setProyecto(proyecto);
        tareaQueyahabia.setTrabajador(trabajador);
        tareaQueyahabia.setDescripcion(tarea.getDescripcion());
        tareaQueyahabia.setEstado(tarea.isEstado());
        tareaQueyahabia.setDias_Estimados(tarea.getDias_Estimados());
        tareaQueyahabia.setFechaf(tarea.getFechaf());
        tareaQueyahabia.setFechai(tarea.getFechai());
        servicio.GuardarTarea(tareaQueyahabia);
        return "redirect:/tareas";
    }

    @GetMapping("/tareas/filtradas")
    public String verTareasFiltradas(@RequestParam(required = false) String fechaMin,
                                     @RequestParam(required = false) String fechaMax,
                                     Model modelo){


        List<Tarea> tareasFiltradas;
        LocalDate hoy = LocalDate.now();
        List<String> diasFaltantes;

        if (fechaMin != null && fechaMax != null && !fechaMin.isEmpty() && !fechaMax.isEmpty()) {
            LocalDate desde = LocalDate.parse(fechaMin);
            LocalDate hasta = LocalDate.parse(fechaMax);
            tareasFiltradas = servicio.BuscarPorRangoFechas(desde, hasta);
        } else {
            tareasFiltradas = servicio.ListarTareas();
        }

        diasFaltantes = tareasFiltradas.stream().map(t -> {
            long dias = ChronoUnit.DAYS.between(hoy, t.getFechaf());
            if (dias > 0) return "Faltan " + dias + " días";
            else if (dias < 0) return "Atrasado " + Math.abs(dias) + " días";
            else return "Vence hoy";
        }).collect(Collectors.toList());

        modelo.addAttribute("tareas", tareasFiltradas);
        modelo.addAttribute("diferenciasDias", diasFaltantes);
        modelo.addAttribute("fechaMin", fechaMin);
        modelo.addAttribute("fechaMax", fechaMax);

        return "tareas_filtradas";
    }





}
