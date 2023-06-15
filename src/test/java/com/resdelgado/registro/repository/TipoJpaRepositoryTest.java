package com.resdelgado.registro.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.resdelgado.registro.model.Tipo;

public class TipoJpaRepositoryTest {

    @Autowired
    private ITipoJpaReposiroty tipo;

    Tipo pasajero = new Tipo("PASAJERO");
    Tipo empLimpieza = new Tipo("LIMPIEZA");
    Tipo empSereno = new Tipo("SERENO");

    pasajero=tipo.assertNotNull(pasajero);

}