package com.sisgebi.service;

import com.sisgebi.entity.Marca;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    // Obtener todas las marcas
    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    // Obtener una marca por ID
    public Optional<Marca> getById(String marcaId) {
        return marcaRepository.findById(marcaId);
    }

    // Crear una nueva marca
    public Marca create(Marca marca) {
        return marcaRepository.save(marca);
    }

    // Actualizar una marca existente
    public Marca update(String marcaId, Marca marca) {
        if (marcaRepository.existsById(marcaId)) {
            marca.setMarcaId(marcaId);
            return marcaRepository.save(marca);
        }
        return null; // O lanzar excepción
    }

    // Eliminar una marca por ID
    public void delete(String id) {
        Optional<Marca> marcaOptional = marcaRepository.findById(id);
        if (marcaOptional.isPresent()) {
            Marca marca = marcaOptional.get();
            marca.setStatus(Status.INACTIVO); // Cambia el estado a INACTIVO
            marcaRepository.save(marca); // Guarda el cambio en la base de datos
        } else {
            return;
        }
    }

    // Filtrar marcas según ID y/o estado
    public List<Marca> filter(String marcaId, Status status) {
        if (marcaId != null && status != null) {
            return marcaRepository.findBymarcaIdAndStatus(marcaId, status); // Filtra por marca y estado
        } else if (marcaId != null) {
            return marcaRepository.findById(marcaId).map(List::of).orElse(List.of()); // Filtra solo por marca
        } else if (status != null) {
            return marcaRepository.findByStatus(status); // Filtra solo por estado
        } else {
            return marcaRepository.findAll(); // Si no hay filtros, devuelve todo
        }
    }
}