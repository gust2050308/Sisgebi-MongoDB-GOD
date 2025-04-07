package com.sisgebi.controller;

import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import com.sisgebi.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    // Obtener todos los modelos
    @GetMapping
    public List<Modelo> getAll() {
        return modeloService.getAll();
    }

    // Obtener modelo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getById(@PathVariable Long id) {
        Optional<Modelo> modelo = modeloService.getById(id);
        return modelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo modelo
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Modelo> create(
            @RequestParam("nombreModelo") String nombreModelo,
            @RequestParam("status") Status status,
            @RequestParam(value = "foto", required = false) MultipartFile foto) {

        try {
            Modelo modelo = new Modelo();
            modelo.setNombreModelo(nombreModelo);
            modelo.setStatus(status);

            if (foto != null && !foto.isEmpty()) {
                modelo.setFoto(foto.getBytes());
            }

            Modelo createdModelo = modeloService.create(modelo);
            return new ResponseEntity<>(createdModelo, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Actualizar modelo
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<Modelo> update(
            @PathVariable Long id,
            @RequestParam("nombreModelo") String nombreModelo,
            @RequestParam("status") Status status,
            @RequestParam(value = "foto", required = false) MultipartFile foto) {

        try {
            Modelo existingModelo = modeloService.findById(id);
            if (existingModelo == null) {
                return ResponseEntity.notFound().build();
            }

            existingModelo.setNombreModelo(nombreModelo);
            existingModelo.setStatus(status);

            if (foto != null && !foto.isEmpty()) {
                existingModelo.setFoto(foto.getBytes());
            }

            Modelo updatedModelo = modeloService.update(id, existingModelo);
            return ResponseEntity.ok(updatedModelo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Eliminar modelo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id) {
        try {
            modeloService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Filtrar modelos
    @GetMapping("/filter")
    public List<Modelo> filter(@RequestParam(required = false) Status status,
                               @RequestParam(required = false) Long modeloId) {
        return modeloService.filter(modeloId, status);
    }
}
