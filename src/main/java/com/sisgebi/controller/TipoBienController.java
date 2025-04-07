package com.sisgebi.controller;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.enums.Status;
import com.sisgebi.service.TipoBienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo-bien")
public class TipoBienController {

    @Autowired
    private TipoBienService tipoBienService;

    public TipoBienController(TipoBienService tipoBienService) {
        this.tipoBienService = tipoBienService;
    }

    // Obtener todos los tipos de bien
    @GetMapping
    public List<TipoBien> getAll() {
        return tipoBienService.getAll();
    }

    // Obtener tipo de bien por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoBien> getById(@PathVariable Long id) {
        Optional<TipoBien> tipoBien = tipoBienService.getById(id);
        return tipoBien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo tipo de bien
    @PostMapping
    public ResponseEntity<TipoBien> create(@RequestBody TipoBien tipoBien) {
        TipoBien createdTipoBien = tipoBienService.create(tipoBien);
        return new ResponseEntity<>(createdTipoBien, HttpStatus.CREATED);
    }

    // Actualizar tipo de bien
    @PutMapping("/{id}")
    public ResponseEntity<TipoBien> update(@PathVariable Long id, @RequestBody TipoBien tipoBien) {
        TipoBien updatedTipoBien = tipoBienService.update(id, tipoBien);
        return updatedTipoBien != null ? ResponseEntity.ok(updatedTipoBien) : ResponseEntity.notFound().build();
    }

    // Eliminar tipo de bien
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoBien(@PathVariable Long id) {
        try {
            tipoBienService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Filtrar tipos de bien
    @GetMapping("/filter")
    public List<TipoBien> filter(@RequestParam(required = false) Long tipoBienId,
                                 @RequestParam(required = false) Status status) {
        return tipoBienService.filter(tipoBienId, status);
    }
}
