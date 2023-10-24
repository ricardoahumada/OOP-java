package com.myshoppingcart.persistence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ProductosDBRepositoryTest {

    @Test
    void dadosUsuarios_cuandoExisteUsuarioEnDB_entoncesOK() {
        boolean existe = ProductosDBRepository.existeUsuario("juana@e.com", "juanason_1");
        assertThat(existe, is(true));
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioNoEnDB_entoncesNOK() {
        boolean existe = ProductosDBRepository.existeUsuario("xxxx@e.com", "xxxx");
        assertThat(existe, is(false));
    }
}