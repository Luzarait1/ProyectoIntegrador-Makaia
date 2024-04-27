package com.example.proyectoIntegradorP.Service;


import com.example.proyectoIntegradorP.DTO.ProyectoDto;
import com.example.proyectoIntegradorP.Models.ProjectStatus;
import com.example.proyectoIntegradorP.Models.Proyecto;
import com.example.proyectoIntegradorP.Repository.ProyectoRepository;
import com.example.proyectoIntegradorP.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProyectoService {

    private ProyectoRepository proyectoRepository;
    private TareaRepository tareaRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }

    public Proyecto crearProyecto(ProyectoDto proyectoDto) {
        Proyecto nuevoProyecto = new Proyecto();
        nuevoProyecto.setNombre(proyectoDto.getNombre());
        nuevoProyecto.setDescripcion(proyectoDto.getDescripcion());
        nuevoProyecto.setStatus(ProjectStatus.ACTIVE.toString());
        nuevoProyecto.setCreatedDate(LocalDateTime.now());
        nuevoProyecto.setLastUpdatedDate(LocalDateTime.now());

        Proyecto proyectoGuardado = proyectoRepository.save(nuevoProyecto);
        return proyectoGuardado;
    }

    public Proyecto editarProyecto(Long idProyecto, Proyecto proyecto) {
        Optional<Proyecto> proyectoExiste = proyectoRepository.findById(idProyecto);

        if(proyectoExiste.isPresent()) {
            proyectoRepository.save(proyecto);
            System.out.println("El proyecto con id " + idProyecto + " se edito correctamente");
            return proyecto;
        } else {
            System.out.println("El proyecto con id " + idProyecto + " no se logro editar");
        }
        //Careful - use exception
        return proyecto;
    }

    public void eliminarProyecto(Long idProyecto) {
        Optional <Proyecto> proyectoExiste = proyectoRepository.findById(idProyecto);
        if(proyectoExiste.isPresent()){
            proyectoRepository.deleteById(idProyecto);
        } else {
            System.out.println("El proyecto no existe");
        }
    }

    public Proyecto encontrarProyecto(Long idProyecto) {
        Optional <Proyecto> proyectoExiste = proyectoRepository.findById(idProyecto);
        if(proyectoExiste.isPresent()) {
            return proyectoExiste.get();
        } else {
            System.out.println("El proyecto no fue encontrado");
        }
        //Careful - use exception
        return proyectoExiste.get();
    }

    public Proyecto obtenerProyecto(Long id) {
        Optional <Proyecto> proyectoExiste = proyectoRepository.findById(id);
        if(proyectoExiste.isPresent()) {
            return proyectoExiste.get();
        } else {
            System.out.println("El proyecto no fue encontrado");
        }
        //Careful - use exception
        return proyectoExiste.get();
    }
}

