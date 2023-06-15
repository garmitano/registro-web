package com.resdelgado.registro.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.resdelgado.registro.model.Persona;
import com.resdelgado.registro.model.Registro;
import com.resdelgado.registro.model.Tipo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonaJpaRepositoryTest {

    @Autowired
    private IPersonaJpaRepository repoPersona;

    @Autowired
    private IRegistroJpaRepository repoRegistro;

    @Autowired
    private ITipoJpaReposiroty repoTipo;

    @Test
    public void savePersona() {

        Tipo pasajero = new Tipo("PASAJERO");
        Tipo empleado = new Tipo("EMPLEADO");

        pasajero = repoTipo.save(pasajero);
        empleado = repoTipo.save(empleado);

        Registro reg1 = new Registro("hab doble");
        Registro reg2 = new Registro("hab triple");

        reg1 = repoRegistro.save(reg1);
        reg2 = repoRegistro.save(reg2);

        Persona pas1 = new Persona(25173444, "Gustavo", pasajero);
        Persona emp1 = new Persona(23562356, "bety", empleado);

        pas1.getRegistros().add(reg1);
        pas1.getRegistros().add(reg2);
        emp1.getRegistros().add(reg2);

        repoPersona.save(pas1);
        repoPersona.save(emp1);

        repoPersona.flush();

        Persona gustavo = repoPersona.findByDni(25173444);

        assertEquals(2, repoPersona.findAll().size());
        assertEquals(pasajero, gustavo.getTipo());
    }
}