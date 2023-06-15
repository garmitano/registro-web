package com.resdelgado.registro.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 11, nullable = false)
    private int dni;
    @Column(length = 45, nullable = false)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "persona_registro", joinColumns = { @JoinColumn(name = "persona_id") }, inverseJoinColumns = {
            @JoinColumn(name = "registro_id") })
    private List<Registro> registros = new ArrayList<Registro>();

    public Persona() {
    }

    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Persona(int dni, String nombre, Tipo tipo) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
    }

}
