package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modeloId;

    @NotBlank(message = "El nombre del modelo es obligatorio")
    @Column(name = "nombre_modelo", nullable = false, unique = true)
    private String nombreModelo;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] foto;

    @NotNull(message = "El estado del modelo es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public @NotBlank(message = "El nombre del modelo es obligatorio") String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(@NotBlank(message = "El nombre del modelo es obligatorio") String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public @NotNull(message = "El estado del modelo es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado del modelo es obligatorio") Status status) {
        this.status = status;
    }
}
