package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "area_comun") // Nombre de la colección en MongoDB
public class AreaComun {

    @Id
    private String areaId; // MongoDB usa String por default para el ID

    @NotBlank(message = "El nombre del área es obligatorio")
    private String nombreArea;

    @NotNull(message = "El estado del área es obligatorio")
    private Status status;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
