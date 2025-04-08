package com.sisgebi.repository;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoBienRepository extends MongoRepository<TipoBien, String> {

    // Filtrar por ID de tipo de bien y estado
    List<TipoBien> findByTipoBienIdAndStatus(String tipoBienId, Status status);

    // Filtrar solo por estado
    List<TipoBien> findByStatus(Status status);
}
