package com.example.proyectoIntegradorP.Controllers;

import com.example.proyectoIntegradorP.DTO.ProyectoDto;
import com.example.proyectoIntegradorP.Models.Proyecto;
import com.example.proyectoIntegradorP.Service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1/proyecto")
public class ProyectoController {

    private ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }
/*
    @DeleteMapping("/")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable("idProyecto") Long idProyecto) {
        this.proyectoService.eliminarProyecto(idProyecto);
        return ResponseEntity.noContent().build();
    }

 */

    @DeleteMapping("/{idProyecto}")
    public void eliminarProyecto(@PathVariable("idProyecto") Long idProyecto) {
        this.proyectoService.eliminarProyecto(idProyecto);
        System.out.println("El proyecto " + idProyecto + " fue eliminado");
    }

    @PostMapping("/")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody ProyectoDto proyectoDto) {
        Proyecto proyectoCreado = proyectoService.crearProyecto(proyectoDto);
        return ResponseEntity.created(URI.create("/v1/proyecto" + proyectoCreado.getIdProyecto())).body(proyectoCreado);
    }

    @GetMapping("/{idProyecto}")
    public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable("idProyecto") Long idProyecto) {
        Proyecto proyecto = proyectoService.obtenerProyecto(idProyecto);
        return ResponseEntity.ok(proyecto);
    }

    @PutMapping("/{idProyecto}")
    public ResponseEntity<Proyecto> editarProyecto(@PathVariable("idProyecto") Long idProyecto, @RequestBody Proyecto proyecto) {
        Proyecto proyectoEdit = proyectoService.editarProyecto(idProyecto, proyecto);
        return ResponseEntity.created(URI.create("/v1/projects" + proyectoEdit.getIdProyecto())).body(proyectoEdit);
    }
}