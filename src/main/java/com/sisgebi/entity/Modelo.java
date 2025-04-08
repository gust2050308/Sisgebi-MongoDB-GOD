package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modelo")
public class Modelo {

    @Id
    private String modeloId;

    @NotBlank(message = "El nombre del modelo es obligatorio")
    private String nombreModelo;

    private byte[] foto;

    @NotNull(message = "El estado del modelo es obligatorio")
    private Status status;

    public String getModeloId() {
        return modeloId;
    }

    public void setModeloId(String modeloId) {
        this.modeloId = modeloId;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
