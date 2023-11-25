package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UsuarioJPARepository extends JpaRepository<Usuario, Long> {
    @Transactional
    @Modifying
    @Query(
            value = "truncate table usuario",
            nativeQuery = true
    )
    void truncate();
}
