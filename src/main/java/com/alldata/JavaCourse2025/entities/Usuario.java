package com.alldata.JavaCourse2025.entities;/*
 * @created 11/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String correo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Orden> ordenes;

    public Usuario(Long id, String nombre, String correo, Perfil perfil, List<Orden> ordenes, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
        this.ordenes = ordenes;
        this.edad = edad;
    }
    public Usuario(String nombre, String correo, Perfil perfil, List<Orden> ordenes, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
        this.ordenes = ordenes;
        this.edad = edad;
    }

    public Usuario() {
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Column(nullable = false)
    private int edad;

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
