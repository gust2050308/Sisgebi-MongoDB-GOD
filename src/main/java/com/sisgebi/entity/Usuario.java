package com.sisgebi.entity;

import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Los nombres son obligatorios")
    @Column(nullable = false)
    private String nombres;

    @NotNull(message = "El apellidos son obligatorios")
    @Column(nullable = false)
    private String apellidos;

    @NotNull(message = "El correo es obligatorio")
    @Column(unique = true, nullable = false)
    private String correo;

    @NotNull(message = "La contrasena es obligatoria")
    @Column(nullable = false)
    private String contrasena;

    @NotNull(message = "El lugar es obligatorio")
    @Column(nullable = false)
    private String lugar;

    @NotNull(message = "El rol del usuario es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rol; // Enum: ADMINISTRADOR, RESPONSABLE, BECARIO

    @NotNull(message = "El estado del usuario es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Los nombres son obligatorios") String getNombres() {
        return nombres;
    }

    public void setNombres(@NotNull(message = "Los nombres son obligatorios") String nombres) {
        this.nombres = nombres;
    }

    public @NotNull(message = "El apellidos son obligatorios") String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NotNull(message = "El apellidos son obligatorios") String apellidos) {
        this.apellidos = apellidos;
    }

    public @NotNull(message = "El correo es obligatorio") String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotNull(message = "El correo es obligatorio") String correo) {
        this.correo = correo;
    }

    public @NotNull(message = "La contrasena es obligatoria") String getContrasena() {
        return contrasena;
    }

    public void setContrasena(@NotNull(message = "La contrasena es obligatoria") String contrasena) {
        this.contrasena = contrasena;
    }

    public @NotNull(message = "El lugar es obligatorio") String getLugar() {
        return lugar;
    }

    public void setLugar(@NotNull(message = "El lugar es obligatorio") String lugar) {
        this.lugar = lugar;
    }

    public @NotNull(message = "El rol del usuario es obligatorio") RolUsuario getRol() {
        return rol;
    }

    public void setRol(@NotNull(message = "El rol del usuario es obligatorio") RolUsuario rol) {
        this.rol = rol;
    }

    public @NotNull(message = "El estado del usuario es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado del usuario es obligatorio") Status status) {
        this.status = status;
    }
}