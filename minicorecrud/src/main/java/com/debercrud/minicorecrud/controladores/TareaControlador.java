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
        tareaQueyahabia.setFecha_fin(tarea.getFecha_fin());
        tareaQueyahabia.setFecha_inicio(tarea.getFecha_inicio());
        servicio.GuardarTarea(tareaQueyahabia);
        return "redirect:/tareas";
    }





}
