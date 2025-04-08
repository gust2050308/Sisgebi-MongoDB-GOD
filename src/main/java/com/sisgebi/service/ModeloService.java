package com.sisgebi.service;

import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    // Obtener todos los modelos
    public List<Modelo> getAll() {
        return modeloRepository.findAll();
    }

    // Obtener modelo por ID
    public Optional<Modelo> getById(String id) {
        return modeloRepository.findById(id);
    }


    // Añade este método que falta
    public Modelo findById(String  id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo no encontrado"));
    }

    // Crear un nuevo modelo
    public Modelo create(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    // Actualizar modelo
    public Modelo update(String id, Modelo modelo) {
        if (modeloRepository.existsById(id)) {
            modelo.setModeloId(id);
            return modeloRepository.save(modelo);
        }
        return null;
    }

    // Eliminar modelo
    public void delete(String id) {
        Optional<Modelo> modeloOptional = modeloRepository.findById(id);
        if (modeloOptional.isPresent()) {
            Modelo modelo = modeloOptional.get();
            modelo.setStatus(Status.INACTIVO); // Cambia el estado a INACTIVO
            modeloRepository.save(modelo); // Guarda el cambio en la base de datos
        } else {
            return;
        }
    }

    // Filtrar modelos por ID y/o estado
    public List<Modelo> filter(String modeloId, Status status) {
        if (modeloId != null && status != null) {
            return modeloRepository.findBymodeloIdAndStatus(modeloId, status); // Filtra por modelo y estado
        } else if (modeloId != null) {
            return modeloRepository.findById(modeloId).map(List::of).orElse(List.of()); // Filtra solo por modelo
        } else if (status != null) {
            return modeloRepository.findByStatus(status); // Filtra solo por estado
        } else {
            return modeloRepository.findAll(); // Si no hay filtros, devuelve todo
        }
    }
}
