package com.example.proyectoIntegradorP.Models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarea;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descipcion;

    @Column(name = "taskStatus")
    @Enumerated(EnumType.STRING)
    private TaskStatus tareaStatus;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_inicio")
    private LocalDate startDate;

    @Column(name = "fecha_entrega")
    private LocalDate dueDate;

    @Column(name = "fecha_creacion")
    private LocalDate createdDate;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime lastUpdatedDate;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", nullable = false)
    private Proyecto proyecto;


    public Tarea(Long idTarea, String nombre, String descipcion, TaskStatus tareaStatus, String tipo, LocalDate startDate, LocalDate dueDate, LocalDate createdDate, LocalDateTime lastUpdatedDate, Proyecto proyecto) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descipcion = descipcion;
        this.tareaStatus = tareaStatus;
        this.tipo = tipo;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.proyecto = proyecto;
    }

    public Tarea() {
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public TaskStatus getTareaStatus() {
        return tareaStatus;
    }

    public void setTareaStatus(TaskStatus tareaStatus) {
        this.tareaStatus = tareaStatus;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}


