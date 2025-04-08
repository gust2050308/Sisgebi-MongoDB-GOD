package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipo_bien")
public class TipoBien {

    @Id
    private String tipoBienId;

    @NotBlank(message = "El nombre del tipo de bien es obligatorio")
    private String nombreTipoBien;

    @NotNull(message = "El estado del tipo de bien es obligatorio")
    private Status status;

    public String getTipoBienId() {
        return tipoBienId;
    }

    public void setTipoBienId(String tipoBienId) {
        this.tipoBienId = tipoBienId;
    }

    public String getNombreTipoBien() {
        return nombreTipoBien;
    }

    public void setNombreTipoBien(String nombreTipoBien) {
        this.nombreTipoBien = nombreTipoBien;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
