package com.example.proyectoIntegradorP.Service;

import com.example.proyectoIntegradorP.DTO.ProyectoDto;
import com.example.proyectoIntegradorP.DTO.TareaDto;
import com.example.proyectoIntegradorP.Models.*;
import com.example.proyectoIntegradorP.Repository.ProyectoRepository;
import com.example.proyectoIntegradorP.Repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TareaService {

    private ProyectoRepository proyectoRepository;
    private TareaRepository tareaRepository;

    public TareaService(ProyectoRepository proyectoRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }

    /*
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


        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo; ---
        this.startDate = startDate;
        this.dueDate = dueDate;
     */
    public Tarea crearTarea(Long idProyecto, TareaDto tareaDto) {

        Optional<Proyecto> proyectoPadre = proyectoRepository.findById(idProyecto);
        if (!proyectoPadre.isPresent()) {
            System.out.println("El proyecto no esta");
        }


        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setNombre(tareaDto.getNombre());
        nuevaTarea.setDescipcion(tareaDto.getDescripcion());
        nuevaTarea.setTareaStatus(TaskStatus.TODO);
        nuevaTarea.setTipo(tareaDto.getTipo());
        nuevaTarea.setStartDate(tareaDto.getStartDate());
        nuevaTarea.setDueDate(tareaDto.getDueDate());
        nuevaTarea.setCreatedDate(LocalDate.now());
        nuevaTarea.setLastUpdatedDate(LocalDateTime.now());
        nuevaTarea.setProyecto(proyectoPadre.get());

        Tarea tareaGuardada = tareaRepository.save(nuevaTarea);
        return tareaGuardada;
    }



}
