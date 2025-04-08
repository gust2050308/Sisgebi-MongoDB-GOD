package com.sisgebi.controller;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import com.sisgebi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bienes")
public class BienController {

    @Autowired
    private BienService bienService;

    // Obtener todos los bienes
    @GetMapping
    public List<Bien> getAllBienes() {
        return bienService.getAllBienes();
    }

    // Obtener un bien por id
    @GetMapping("/{id}")
    public ResponseEntity<Bien> getBienById(@PathVariable String id) {
        Optional<Bien> bien = bienService.getBienById(id);
        return bien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo bien
    @PostMapping
    public ResponseEntity<Bien> createBien(@RequestBody Bien bien) {
        Bien createdBien = bienService.createBien(bien);
        return new ResponseEntity<>(createdBien, HttpStatus.CREATED);
    }

    // Actualizar un bien
    @PutMapping("/{id}")
    public ResponseEntity<Bien> updateBien(@PathVariable String id, @RequestBody Bien bien) {
        Bien updatedBien = bienService.updateBien(id, bien);
        return updatedBien != null ? ResponseEntity.ok(updatedBien) : ResponseEntity.notFound().build();
    }

    // Eliminar un bien con motivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBien(@PathVariable String id, @RequestParam String motivo) {
        try {
            bienService.deleteBien(id, motivo);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Bien>> filterBienes(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String tipoBienId,
            @RequestParam(required = false) String marcaId,
            @RequestParam(required = false) String  modeloId,
            @RequestParam(required = false) String areaId,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) Disponibilidad disponibilidad) {

        List<Bien> bienes = bienService.filter(id, codigo, tipoBienId, marcaId, modeloId, areaId, status, disponibilidad);
        return ResponseEntity.ok(bienes);
    }
}
