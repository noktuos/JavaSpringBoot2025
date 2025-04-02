package com.alldata.JavaCourse2025.entities;/*
 * @created 12/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import jakarta.persistence.*;

@Entity
@Table(name = "cat_perfiles")
public class Perfil {
    public Perfil(Long id, String nombrePerfil) {
        this.id = id;
        this.nombrePerfil = nombrePerfil;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column (nullable = false,unique = true)
    private String nombrePerfil;


    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil() {
    }

    public Perfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
}
