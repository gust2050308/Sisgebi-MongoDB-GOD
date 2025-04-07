package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import com.sisgebi.enums.Disponibilidad;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {

    @Query("SELECT DISTINCT b.codigo FROM Bien b")
    List<String> findDistinctCodigo();

    @Query("SELECT DISTINCT b.numeroSerie FROM Bien b")
    List<String> findDistinctNumeroSerie();


    @Query("SELECT b FROM Bien b WHERE " +
            "(:id IS NULL OR b.usuario.id =:id) AND" +
            "(:codigo IS NULL OR b.codigo =:codigo) AND" +
            "(:tipoBienId IS NULL OR b.tipoBien.tipoBienId = :tipoBienId) AND " +
            "(:marcaId IS NULL OR b.marca.marcaId = :marcaId) AND " +
            "(:modeloId IS NULL OR b.modelo.modeloId = :modeloId) AND " +
            "(:areaId IS NULL OR b.areaComun.areaId = :areaId) AND " +
            "(:status IS NULL OR b.status = :status) AND " +
            "(:disponibilidad IS NULL OR b.disponibilidad = :disponibilidad)")
    List<Bien> filter(
            @Param("id") Long id,
            @Param("codigo") String codigo,
            @Param("tipoBienId") Long tipoBienId,
            @Param("marcaId") Long marcaId,
            @Param("modeloId") Long modeloId,
            @Param("areaId") Long areaId,
            @Param("status") Status status,
            @Param("disponibilidad") Disponibilidad disponibilidad
    );
}
