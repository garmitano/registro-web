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
public class RegistroDto {
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    @Size(max = 45)
    private String detalle;

    public RegistroDto(@NotBlank @Size(max = 45) String detalle) {
        this.detalle = detalle;
    }
}
