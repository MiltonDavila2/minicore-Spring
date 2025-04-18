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
    private LocalDate fechai;

    @Column(name = "fecha_fin")
    private LocalDate fechaf;

    public Tarea() {
    }

    public Tarea(String descripcion, int dias_Estimados, boolean estado, Trabajador trabajador, Proyecto proyecto, LocalDate fechai, LocalDate fechaf) {
        Descripcion = descripcion;
        this.dias_Estimados = dias_Estimados;
        Estado = estado;
        this.trabajador = trabajador;
        this.proyecto = proyecto;
        this.fechai = fechai;
        this.fechaf = fechaf;
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

    public LocalDate getFechai() {
        return fechai;
    }

    public void setFechai(LocalDate fechai) {
        this.fechai = fechai;
    }

    public LocalDate getFechaf() {
        return fechaf;
    }

    public void setFechaf(LocalDate fechaf) {
        this.fechaf = fechaf;
    }
}