package com.sisgebi.repository;

import com.sisgebi.entity.Modelo;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    // Filtrar por ID modelo y estado
    List<Modelo> findBymodeloIdAndStatus(Long modeloId, Status status);

    // Filtrar solo por estado
    List<Modelo> findByStatus(Status status);
}
