package com.sisgebi.repository;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaComunRepository extends MongoRepository<AreaComun, String> {

    // Filtrar por ID de área y estado
    List<AreaComun> findByAreaIdAndStatus(String areaId, Status status);

    // Filtrar solo por estado
    List<AreaComun> findByStatus(Status status);
}
