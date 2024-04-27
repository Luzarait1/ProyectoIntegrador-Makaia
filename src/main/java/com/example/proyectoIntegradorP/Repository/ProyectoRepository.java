package com.example.proyectoIntegradorP.Repository;

import com.example.proyectoIntegradorP.Models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {


}