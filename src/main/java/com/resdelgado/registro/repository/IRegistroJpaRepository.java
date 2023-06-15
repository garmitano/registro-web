package com.resdelgado.registro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resdelgado.registro.model.Registro;

public interface IRegistroJpaRepository extends JpaRepository<Registro, Long> {
    List<Registro> findByDetalle(String detalle);
}
