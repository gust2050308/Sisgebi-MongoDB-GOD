package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_bien")
public class TipoBien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoBienId;

    @NotBlank(message = "El nombre del tipo de bien es obligatorio")
    @Column(name = "nombre_tipo_bien", nullable = false, unique = true)
    private String nombreTipoBien;

    @NotNull(message = "El estado del tipo de bien es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Long getTipoBienId() {
        return tipoBienId;
    }

    public void setTipoBienId(Long tipoBienId) {
        this.tipoBienId = tipoBienId;
    }

    public @NotBlank(message = "El nombre del tipo de bien es obligatorio") String getNombreTipoBien() {
        return nombreTipoBien;
    }

    public void setNombreTipoBien(@NotBlank(message = "El nombre del tipo de bien es obligatorio") String nombreTipoBien) {
        this.nombreTipoBien = nombreTipoBien;
    }

    public @NotNull(message = "El estado del tipo de bien es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado del tipo de bien es obligatorio") Status status) {
        this.status = status;
    }
}
