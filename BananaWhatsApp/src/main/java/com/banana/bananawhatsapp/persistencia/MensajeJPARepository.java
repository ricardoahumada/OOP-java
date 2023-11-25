package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MensajeJPARepository extends JpaRepository<Mensaje, Long> {
    @Transactional
    @Modifying
    @Query(
            value = "truncate table mensaje",
            nativeQuery = true
    )
    void truncate();
}
