package com.sisgebi.entity;

import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {

    @Id
    private String id;

    @NotNull(message = "Los nombres son obligatorios")
    private String nombres;

    @NotNull(message = "El apellidos son obligatorios")
    private String apellidos;

    @NotNull(message = "El correo es obligatorio")
    private String correo;

    @NotNull(message = "La contrasena es obligatoria")
    private String contrasena;

    @NotNull(message = "El lugar es obligatorio")
    private String lugar;

    @NotNull(message = "El rol del usuario es obligatorio")
    private RolUsuario rol;

    @NotNull(message = "El estado del usuario es obligatorio")
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}