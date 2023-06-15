package com.resdelgado.registro.service;

import java.util.List;

import com.resdelgado.registro.dto.TipoDto;

import jakarta.validation.Valid;

public interface ITipoService {
    public TipoDto save(@Valid TipoDto tipo);

    public TipoDto get(Long id);

    public List<TipoDto> getAll();

    public void delete(Long id);
}
