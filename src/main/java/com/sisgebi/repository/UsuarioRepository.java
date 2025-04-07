package com.sisgebi.repository;

import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.RolUsuario;
import com.sisgebi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Filtrar por correo
    Optional<Usuario> findByCorreo(String correo);

    // Filtrar por estado
    List<Usuario> findByStatus(Status status);

    // Filtrar por rol
    List<Usuario> findByRol(RolUsuario rol);

    // Filtrar por lugar (exacto)
    List<Usuario> findByLugar(String lugar);

    // Filtrar combinando rol y estado
    List<Usuario> findByRolAndStatus(RolUsuario rol, Status status);

    // Filtrar combinando rol y lugar
    List<Usuario> findByRolAndLugar(RolUsuario rol, String lugar);

    // Filtrar combinando estado y lugar
    List<Usuario> findByStatusAndLugar(Status status, String lugar);

    // Filtrar combinando los tres
    List<Usuario> findByRolAndStatusAndLugar(RolUsuario rol, Status status, String lugar);

    @Query("SELECT DISTINCT u.lugar FROM Usuario u")
    List<String> findDistinctLugares();
}
