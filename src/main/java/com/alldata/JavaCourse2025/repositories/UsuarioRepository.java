package com.alldata.JavaCourse2025.repositories;/*
 * @created 11/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByCorreo(String correo);

    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
    Usuario buscarPorEmail(@Param("email")  String correo);
    @Query("SELECT u FROM Usuario u where u.nombre = :nombre AND u.edad > :edad")
    List<Usuario> buscarPorNombreyEdad(@Param("nombre") String nombre, @Param("edad") int edad);

    @Override
    default <S extends Usuario> S saveAndFlush(S entity) {
        return entity;
    }
}
