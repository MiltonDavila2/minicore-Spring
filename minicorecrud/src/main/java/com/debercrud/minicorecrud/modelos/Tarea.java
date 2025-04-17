package com.debercrud.minicorecrud.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "descripcion")
    private String Descripcion;

    @Column(name = "dias_estimados")
    private int dias_Estimados;

    @Column(name = "estado")
    private boolean Estado;

    @ManyToOne
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id")
    private Trabajador trabajador;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
    private Proyecto proyecto;

    @Column(name = "fecha_inicio")
    private LocalDate fecha_inicio;

    @Column(name = "fecha_fin")
    private LocalDate fecha_fin;

    public Tarea() {
    }

    public Tarea(String descripcion, int dias_Estimados, boolean estado, Trabajador trabajador, Proyecto proyecto, LocalDate fecha_inicio, LocalDate fecha_fin) {
        Descripcion = descripcion;
        this.dias_Estimados = dias_Estimados;
        Estado = estado;
        this.trabajador = trabajador;
        this.proyecto = proyecto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getDias_Estimados() {
        return dias_Estimados;
    }

    public void setDias_Estimados(int dias_Estimados) {
        this.dias_Estimados = dias_Estimados;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}