package com.resdelgado.registro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.resdelgado.registro.dto.TipoDto;

import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class TipoContrainsValidationException {
    private static final String ADMIN = "ADMIN";
    @Autowired
    private TipoServiceImpl tipoService;

    @Test
    public void contraintsValidationExceptionTest() {

        assertThrows(ConstraintViolationException.class, () -> {
            tipoService.create(new TipoDto(null));
        });
        assertThrows(ConstraintViolationException.class, () -> {
            tipoService.create(new TipoDto(""));
        });
        assertThrows(ConstraintViolationException.class, () -> {
            tipoService.create(new TipoDto("14654654654654654234567890123456"));
        });

    }

    @Test
    public void createTipoOk() {
        TipoDto tipoDto = tipoService.create(new TipoDto(null, ADMIN));
        assertNotNull(tipoDto);
        assertEquals(ADMIN, tipoDto.getTipo());
        assertNotNull(tipoDto.getId());
    }
}
