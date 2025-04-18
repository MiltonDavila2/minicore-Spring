package com.debercrud.minicorecrud.controladores;

import com.debercrud.minicorecrud.modelos.Trabajador;
import com.debercrud.minicorecrud.servicios.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrabajadorControlador {

    @Autowired
    private TrabajadorServicio servicio;

    @GetMapping("/trabajadores")
    public String listarTrabajadores(Model modelo){
        modelo.addAttribute("trabajadores", servicio.ListarTrabajadores());
        return "trabajadores";
    }


    @GetMapping("/trabajadores/nuevo")
    public String CrearTrabajadorFormulario(Model modelo){
        Trabajador trabajador = new Trabajador();
        modelo.addAttribute("trabajador",trabajador);
        return "crear_trabajador";

    }

    @PostMapping("/trabajadores")
    public String GuardarTrabajador(@ModelAttribute("trabajador") Trabajador trabajador){
        servicio.GuardarTrabajador(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/trabajadores/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("trabajador",servicio.EncontrarTrabajadorPorID(id));
        return "editar_trabajador";
    }

    @PostMapping("/trabajadores/{id}")
    public String actualizarTrabajador(@PathVariable Long id, @ModelAttribute("trabajador") Trabajador trabajador, Model Modelo){
        Trabajador trabajadorExistente = servicio.EncontrarTrabajadorPorID(id);
        trabajadorExistente.setId(id);
        trabajadorExistente.setNombre(trabajador.getNombre());
        trabajadorExistente.setApellido(trabajador.getApellido());


        servicio.actualizarTrabajador(trabajadorExistente);
        return "redirect:/trabajadores";
    }


}
