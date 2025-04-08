package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRepository extends MongoRepository<Bien, String>, BienRepositoryCustom {

    List<String> findDistinctCodigoBy();

    List<String> findDistinctNumeroSerieBy();
}
