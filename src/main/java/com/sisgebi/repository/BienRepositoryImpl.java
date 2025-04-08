package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BienRepositoryImpl implements BienRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Bien> filterBienes(String id,
                                   String codigo,
                                   String tipoBienId,
                                   String marcaId,
                                   String modeloId,
                                   String areaId,
                                   Status status,
                                   Disponibilidad disponibilidad) {
        Query query = new Query();
        if (id != null) query.addCriteria(Criteria.where("id").is(id));
        if (codigo != null) query.addCriteria(Criteria.where("codigo").is(codigo));
        if (tipoBienId != null) query.addCriteria(Criteria.where("tipoBien.tipoBienId").is(tipoBienId));
        if (marcaId != null) query.addCriteria(Criteria.where("marca.marcaId").is(marcaId));
        if (modeloId != null) query.addCriteria(Criteria.where("modelo.modeloId").is(modeloId));
        if (areaId != null) query.addCriteria(Criteria.where("areaComun.areaId").is(areaId));
        if (status != null) query.addCriteria(Criteria.where("status").is(status));
        if (disponibilidad != null) query.addCriteria(Criteria.where("disponibilidad").is(disponibilidad));

        return mongoTemplate.find(query, Bien.class);
    }
}
