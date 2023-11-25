package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeJPARepository extends JpaRepository<Mensaje, Long> {
}
