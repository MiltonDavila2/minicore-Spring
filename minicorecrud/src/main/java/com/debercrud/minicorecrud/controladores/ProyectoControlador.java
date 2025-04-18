package com.debercrud.minicorecrud.controladores;

import com.debercrud.minicorecrud.modelos.Proyecto;
import com.debercrud.minicorecrud.servicios.ProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProyectoControlador {

    @Autowired
    private ProyectoServicio servicio;

    @GetMapping("/proyectos")
    public String listarProyectos(Model modelo){
        modelo.addAttribute("proyectos",servicio.ListarProyectos());
        return "proyectos";
    }

    @GetMapping("/proyectos/nuevo")
    public String CrearProyectoFormulario(Model modelo){
        Proyecto proyecto = new Proyecto();
        modelo.addAttribute("proyecto",proyecto);
        return "crear_proyecto";
    }


    @PostMapping("/proyectos")
    public String GuardarProyecto(@ModelAttribute("proyecto") Proyecto proyecto){
        servicio.GuardarProyecto(proyecto);
        return "redirect:/proyectos";
    }

    @GetMapping("/proyectos/editar/{id}")
    public String MostrarFormularioEditar(@PathVariable Long id,Model modelo){
        modelo.addAttribute("proyecto",servicio.ObtenerProyectoId(id));
        return "editar_proyecto";
    }

    @PostMapping("/proyectos/{id}")
    public String GuardarEditarProyecto(@PathVariable Long id,@ModelAttribute("proyecto") Proyecto proyecto, Model modelo){
        Proyecto Proyectoexistente = servicio.ObtenerProyectoId(id);
        Proyectoexistente.setId(id);
        Proyectoexistente.setNombre_proyecto(proyecto.getNombre_proyecto());

        servicio.GuardarProyecto(Proyectoexistente);
        return "redirect:/proyectos";

    }



}
