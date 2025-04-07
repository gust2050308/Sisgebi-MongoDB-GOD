package com.sisgebi.entity;

import com.sisgebi.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "asignaciones")
public class Asignaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignacionesId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bien_id", nullable = false)
    private Bien bien;

    @NotNull(message = "El estado del bien es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Long getAsignacionesId() {
        return asignacionesId;
    }

    public void setAsignacionesId(Long asignacionesId) {
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

    public @NotNull(message = "El estado del bien es obligatorio") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El estado del bien es obligatorio") Status status) {
        this.status = status;
    }
}
