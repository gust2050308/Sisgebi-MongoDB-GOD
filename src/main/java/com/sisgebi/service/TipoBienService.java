package com.sisgebi.service;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.TipoBienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class TipoBienService {

    @Autowired
    private TipoBienRepository tipoBienRepository;

    public TipoBienService(TipoBienRepository tipoBienRepository) {
        this.tipoBienRepository = tipoBienRepository;
    }

    // Obtener todos los tipos de bien
    public List<TipoBien> getAll() {
        return tipoBienRepository.findAll();
    }

    // Obtener tipo de bien por ID
    public Optional<TipoBien> getById(String id) {
        return tipoBienRepository.findById(id);
    }

    // Crear nuevo tipo de bien
    public TipoBien create(TipoBien tipoBien) {
        return tipoBienRepository.save(tipoBien);
    }

    // Actualizar tipo de bien
    public TipoBien update(String id, TipoBien tipoBien) {
        if (tipoBienRepository.existsById(id)) {
            tipoBien.setTipoBienId(id);
            return tipoBienRepository.save(tipoBien);
        }
        return null;
    }

    // Eliminar tipo de bien
    public void delete(String id) {
        Optional<TipoBien> tipoBienOptional = tipoBienRepository.findById(id);
        if (tipoBienOptional.isPresent()) {
            TipoBien tipoBien = tipoBienOptional.get();
            tipoBien.setStatus(Status.INACTIVO); // Cambia el estado a INACTIVO
            tipoBienRepository.save(tipoBien); // Guarda el cambio en la base de datos
        } else {
            return;
        }
    }

    // Filtrar tipos de bien según ID y/o estado
    public List<TipoBien> filter(String tipoBienId, Status status) {
        if (tipoBienId != null && status != null) {
            return tipoBienRepository.findByTipoBienIdAndStatus(tipoBienId, status); // Filtra por tipo de bien y estado
        } else if (tipoBienId != null) {
            return tipoBienRepository.findById(tipoBienId).map(List::of).orElse(List.of()); // Filtra solo por tipo de bien
        } else if (status != null) {
            return tipoBienRepository.findByStatus(status); // Filtra solo por estado
        } else {
            return tipoBienRepository.findAll(); // Si no hay filtros, devuelve todo
        }
    }
}
