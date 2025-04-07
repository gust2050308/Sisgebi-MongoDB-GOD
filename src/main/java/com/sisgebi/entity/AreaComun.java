package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "area_comun")
public class AreaComun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;

    @NotBlank(message = "El nombre del área es obligatorio")
    @Column(name = "nombre_area", nullable = false, unique = true)
    private String nombreArea;

    @NotNull(message = "El estado del área es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public @NotBlank(message = "El nombre del área es obligatorio") String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(@NotBlank(message = "El nombre del área es obligatorio") String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public @NotNull(message = "El estado del área es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado del área es obligatorio") Status status) {
        this.status = status;
    }
}
