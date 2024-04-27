package com.example.proyectoIntegradorP.Controllers;


import com.example.proyectoIntegradorP.DTO.ProyectoDto;
import com.example.proyectoIntegradorP.DTO.TareaDto;
import com.example.proyectoIntegradorP.Models.Proyecto;
import com.example.proyectoIntegradorP.Models.Tarea;
import com.example.proyectoIntegradorP.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1/tarea")
public class TareaController {

    private TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping("/{idProyecto}")
    public ResponseEntity<Tarea> crearTarea(@PathVariable("idProyecto") Long idProyecto, @RequestBody TareaDto tareaDto) {
        Tarea tareaCreada = tareaService.crearTarea(idProyecto, tareaDto);
        return ResponseEntity.created(URI.create("/v1/tarea" + tareaCreada.getIdTarea())).body(tareaCreada);
    }
}
