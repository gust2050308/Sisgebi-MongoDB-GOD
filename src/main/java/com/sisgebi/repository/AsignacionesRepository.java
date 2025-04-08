package com.sisgebi.repository;

import com.sisgebi.entity.Asignaciones;
import com.sisgebi.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionesRepository extends MongoRepository<Asignaciones, String> {

    // Filtrar por estado
    List<Asignaciones> findByStatus(Status status);

    // Filtrar por usuario
    List<Asignaciones> findByUsuarioId(String id);

    // Filtrar por estado y usuario
    List<Asignaciones> findByStatusAndUsuarioId(Status status, String id);
}
