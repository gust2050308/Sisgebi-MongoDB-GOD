package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "asignaciones")
public class Asignaciones {

    @Id
    private String asignacionesId;

    @DBRef
    private Usuario usuario;

    @DBRef
    private Bien bien;

    @NotNull(message = "El estado del bien es obligatorio")
    private Status status;

    public String getAsignacionesId() {
        return asignacionesId;
    }

    public void setAsignacionesId(String asignacionesId) {
        this.asignacionesId = asignacionesId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
