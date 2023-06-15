package com.resdelgado.registro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resdelgado.registro.model.Persona;
import com.resdelgado.registro.model.Tipo;

public interface IPersonaJpaRepository extends JpaRepository<Persona, Long> {

    Persona findByDni(int dni);

    List<Persona> findByNombre(String nombre);

    List<Tipo> findByTipos(String tipo);
}
