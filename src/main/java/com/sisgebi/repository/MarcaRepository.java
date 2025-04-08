package com.sisgebi.repository;

import com.sisgebi.entity.Marca;
import com.sisgebi.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends MongoRepository<Marca, String> {

    // Filtrar por ID de marca y estado
    List<Marca> findBymarcaIdAndStatus(String marcaId, Status status);

    // Filtrar solo por estado
    List<Marca> findByStatus(Status status);
}
