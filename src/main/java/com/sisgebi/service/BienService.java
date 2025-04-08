package com.sisgebi.service;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import com.sisgebi.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;
    @Autowired
    private AreaComunService areaComunService;

    public BienService(BienRepository bienRepository) {
        this.bienRepository = bienRepository;
    }

    // Obtener todos los bienes
    public List<Bien> getAllBienes() {
        return bienRepository.findAll();
    }

    // Obtener bien por id
    public Optional<Bien> getBienById(String id) {
        return bienRepository.findById(id);
    }

    // Crear un nuevo bien
    public Bien createBien(Bien bien) {
        return bienRepository.save(bien);
    }

    // Actualizar bien
    public Bien updateBien(String id, Bien bien) {
        if (bienRepository.existsById(id)) {
            bien.setBienId(id);
            return bienRepository.save(bien);
        }
        return null; // O puedes lanzar una excepción si no existe el bien
    }

    // Eliminar bien (borrado lógico con motivo)
    public void deleteBien(String id, String motivo) {
        Optional<Bien> bienOptional = bienRepository.findById(id);
        if (bienOptional.isPresent()) {
            Bien bien = bienOptional.get();
            bien.setStatus(Status.INACTIVO); // Cambiar estado a INACTIVO
            bien.setMotivo(motivo); // Establecer el motivo de la eliminación
            bien.setDeleteAt(LocalDateTime.now()); // Establecer la fecha de eliminación
            bienRepository.save(bien); // Guardar el cambio en la base de datos
        } else {
            return; // Si no se encuentra el bien, simplemente regresa
        }
    }

    // Filtrar bienes según varios atributos
    public List<Bien> filter(String id,
                             String codigo,
                             String  tipoBienId,
                             String marcaId,
                             String modeloId,
                             String areaId,
                             Status status,
                             Disponibilidad disponibilidad) {
        return bienRepository.filterBienes(id, codigo, tipoBienId, marcaId, modeloId, areaId, status, disponibilidad);
    }
}
