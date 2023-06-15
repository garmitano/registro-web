package com.resdelgado.registro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.resdelgado.registro.dto.TipoDto;
import com.resdelgado.registro.model.Tipo;
import com.resdelgado.registro.repository.ITipoJpaReposiroty;

@Service
@Validated
public class TipoServiceImpl implements ITipoService {

    @Autowired
    private ITipoJpaReposiroty tipoRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TipoDto save(TipoDto tipo) {

        Tipo tipoEntity = modelMapper.map(tipo, Tipo.class);
        tipoEntity = tipoRepo.save(tipoEntity);
        return modelMapper.map(tipoEntity, TipoDto.class);
    }

    @Override
    public TipoDto get(Long id) {
        Tipo tipoEntity = tipoRepo.getReferenceById(id);
        TipoDto tipoDto = modelMapper.map(tipoEntity, TipoDto.class);
        return tipoDto;
    }

    @Override
    public List<TipoDto> getAll() {
        List<Tipo> listTipoEntity = tipoRepo.findAll();
        List<TipoDto> listTipoDto = listTipoEntity.stream().map(role -> modelMapper.map(role, TipoDto.class))
                .collect(Collectors.toList());
        return listTipoDto;
    }

    @Override
    public void delete(Long id) {
        tipoRepo.deleteById(id);

    }

}
