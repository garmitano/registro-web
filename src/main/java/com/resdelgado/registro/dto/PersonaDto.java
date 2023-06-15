package com.resdelgado.registro.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonaDto {
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    @Size(max = 11)
    private int dni;
    @NotBlank
    @Size(max = 35)
    private String nombre;
    @NotNull
    private TipoDto tipo;
    private List<RegistroDto> registros = new ArrayList<RegistroDto>();

    public PersonaDto(@NotBlank @Size(max = 11) int dni, @NotBlank @Size(max = 35) String nombre, @NotNull TipoDto tipo,
            List<RegistroDto> registros) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipo = tipo;
        this.registros = registros;
    }

}
