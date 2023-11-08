package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompraDBRepositoryTest {

    private ICompraRepository repo;

    @BeforeEach
    void sepUp() throws IOException {
        repo = new CompraDBRepository();
    }

    @Test
    public void dadaCompraValida_cuandoinsertCompra_entoncesOK() throws Exception {
        Compra compra = new Compra(null, 1, 1, 3, LocalDate.now());

        Compra ncompra = repo.insertCompra(compra);

        assertThat(ncompra.getCid(), greaterThan(1));

    }

    @Test
    public void dadaCompraProductoNoValido_cuandoinsertCompra_entoncesExcepcion() throws Exception {
        Compra compra = new Compra(null, 1, 1034, 3, LocalDate.now());
        assertThrows(Exception.class, ()->{
            Compra ncompra = repo.insertCompra(compra);
        });
    }

    @Test
    public void dadaCompraProductoSinexistenciasSuficients_cuandoinsertCompra_entoncesExcepcion() throws Exception {
        Compra compra = new Compra(null, 1, 1, 300, LocalDate.now());
        assertThrows(Exception.class, ()->{
            Compra ncompra = repo.insertCompra(compra);
        });
    }
}