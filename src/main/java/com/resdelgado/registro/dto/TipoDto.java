package com.resdelgado.registro.dto;

import jakarta.validation.constraints.NotBlank;
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
public class TipoDto {
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    @Size(max = 25)
    private String tipo;

    public TipoDto(@NotBlank @Size(max = 25) String tipo) {
        this.tipo = tipo;
    }

}
