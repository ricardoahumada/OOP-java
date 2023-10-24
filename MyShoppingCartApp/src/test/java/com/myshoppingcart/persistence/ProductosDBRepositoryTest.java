package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void dadosUsuarios_cuandogetUsuarioEnDB_entoncesUsuario() throws Exception {
        Usuario usuario = ProductosDBRepository.getUsuario("juana@e.com", "juanason_1");

        System.out.println(usuario);

        assertThat(usuario.getEmail(), is("juana@e.com"));

    }

    @Test
    void dadosUsuarios_cuandogetUsuarioNoEnDB_entoncesExcepcion() {

        assertThrows(UsuarioNotFoundException.class, () -> {
            Usuario usuario = ProductosDBRepository.getUsuario("xxxx@e.com", "xxxx");
        });

    }

    @Test
    void dadosProductos_cuandogetUserProductsUsuarioEnDB_entoncesProductos() throws Exception {
        List<Producto> productos = ProductosDBRepository.getUserProducts(1);

        System.out.println(productos);

        assertThat(productos.size(), greaterThan(0));

    }

    @Test
    void dadosProductos_cuandogetUserProductsUsuarioNoEnDB_entoncesNull() throws Exception {
        List<Producto> productos = ProductosDBRepository.getUserProducts(100);

        System.out.println(productos);

        assertThat(productos.size(), is(0));

    }
}