package com.sisgebi.repository;

import com.sisgebi.entity.Marca;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    // Filtrar por ID de marca y estado
    List<Marca> findBymarcaIdAndStatus(Long marcaId, Status status);

    // Filtrar solo por estado
    List<Marca> findByStatus(Status status);
}
