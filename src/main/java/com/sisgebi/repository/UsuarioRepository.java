package com.sisgebi.repository;

import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByCorreo(String correo);

    List<Usuario> findByStatus(Status status);

    List<Usuario> findByRol(RolUsuario rol);

    List<Usuario> findByLugar(String lugar);

    List<Usuario> findByRolAndStatus(RolUsuario rol, Status status);

    List<Usuario> findByRolAndLugar(RolUsuario rol, String lugar);

    List<Usuario> findByStatusAndLugar(Status status, String lugar);

    List<Usuario> findByRolAndStatusAndLugar(RolUsuario rol, Status status, String lugar);

    @Aggregation(pipeline = {
            "{ $group: { _id: '$lugar' } }",
            "{ $project: { _id: 0, lugar: '$_id' } }"
    })
    List<String> findDistinctLugares();
}