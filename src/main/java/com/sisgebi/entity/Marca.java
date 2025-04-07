package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marcaId;

    @NotBlank(message = "El nombre de la marca es obligatorio")
    @Column(name = "nombre_marca", nullable = false, unique = true)
    private String nombreMarca;

    @NotNull(message = "El estado de la marca es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    public @NotBlank(message = "El nombre de la marca es obligatorio") String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(@NotBlank(message = "El nombre de la marca es obligatorio") String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public @NotNull(message = "El estado de la marca es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado de la marca es obligatorio") Status status) {
        this.status = status;
    }
}
