package com.sisgebi.entity;

import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Document(collection = "bien")
public class Bien {

    @Id
    private String bienId;

    @NotBlank(message = "El código del bien es obligatorio")
    private String codigo;

    @NotBlank(message = "El número de serie es obligatorio")
    private String numeroSerie;

    @DBRef
    private TipoBien tipoBien;

    @DBRef
    private Marca marca;

    @DBRef
    private Modelo modelo;

    @DBRef
    private AreaComun areaComun;

    @DBRef
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @NotNull(message = "El estado del bien es obligatorio")
    private Status status;

    @NotNull(message = "La disponibilidad del bien es obligatoria")
    private Disponibilidad disponibilidad;

    private String motivo;

    private LocalDateTime deleteAt;

    public String getBienId() {
        return bienId;
    }

    public void setBienId(String bienId) {
        this.bienId = bienId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public TipoBien getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(TipoBien tipoBien) {
        this.tipoBien = tipoBien;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public AreaComun getAreaComun() {
        return areaComun;
    }

    public void setAreaComun(AreaComun areaComun) {
        this.areaComun = areaComun;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    // Puedes llamar este método manualmente antes de guardar para simular lógica de borrado
    public void markAsDeleted() {
        this.deleteAt = LocalDateTime.now();
    }
}
