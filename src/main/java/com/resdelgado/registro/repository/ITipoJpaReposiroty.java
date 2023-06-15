package com.resdelgado.registro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resdelgado.registro.model.Tipo;

public interface ITipoJpaReposiroty extends JpaRepository<Tipo, Long> {
    List<Tipo> findByTipo(String tipo);

    // @Cacheable("tipos")
    List<Tipo> findAll();
}
