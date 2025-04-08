package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;

import java.util.List;

public interface BienRepositoryCustom {
    List<Bien> filterBienes(String id,
                            String codigo,
                            String  tipoBienId,
                            String marcaId,
                            String modeloId,
                            String areaId,
                            Status status,
                            Disponibilidad disponibilidad);
}
