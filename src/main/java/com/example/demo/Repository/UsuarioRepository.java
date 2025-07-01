package com.example.demo.Repository;

import com.example.demo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.io.Serializable;

@Repository("usurepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    public Usuario obtenerUsuario(@Param("id") int id);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}

