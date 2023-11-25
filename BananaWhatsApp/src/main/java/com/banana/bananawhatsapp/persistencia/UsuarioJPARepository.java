package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJPARepository extends JpaRepository<Usuario, Long> {
}
