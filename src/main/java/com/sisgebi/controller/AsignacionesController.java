package com.sisgebi.controller;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.enums.Status;
import com.sisgebi.service.AsignacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionesController {

    @Autowired
    private AsignacionesService asignacionesService;

    // Obtener todas las asignaciones (excluyendo ADMINISTRADORES)
    @GetMapping
    public List<Asignaciones> getAllAsignaciones() {
        return asignacionesService.getAllAsignaciones();
    }

    // Obtener una asignación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignaciones> getAsignacionById(@PathVariable Long id) {
        Asignaciones asignacion = asignacionesService.getAsignacionById(id);
        return asignacion != null ? ResponseEntity.ok(asignacion) : ResponseEntity.notFound().build();
    }

    // Crear una nueva asignación (solo para RESPONSABLES y BECARIOS)
    @PostMapping
    public ResponseEntity<Asignaciones> createAsignacion(@RequestBody Asignaciones asignacion) {
        Asignaciones createdAsignacion = asignacionesService.createAsignacion(asignacion);
        return new ResponseEntity<>(createdAsignacion, HttpStatus.CREATED);
    }

    // Actualizar una asignación (solo para RESPONSABLES y BECARIOS)
    @PutMapping("/{id}")
    public ResponseEntity<Asignaciones> updateAsignacion(@PathVariable Long id, @RequestBody Asignaciones asignacion) {
        Asignaciones updatedAsignacion = asignacionesService.updateAsignacion(id, asignacion);
        return updatedAsignacion != null ? ResponseEntity.ok(updatedAsignacion) : ResponseEntity.notFound().build();
    }

    // Eliminar una asignación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignacion(@PathVariable Long id) {
        try {
            asignacionesService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Filtrar usuarios
    @GetMapping("/filter")
    public List<Asignaciones> filter(@RequestParam(required = false) Status status,
                                     @RequestParam(required = false) Long id) {
        return asignacionesService.filter(id, status);
    }
}