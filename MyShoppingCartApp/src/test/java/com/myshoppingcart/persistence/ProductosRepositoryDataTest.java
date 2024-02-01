package com.myshoppingcart.persistence;

import com.myshoppingcart.config.SpringConfig;
import com.myshoppingcart.model.Producto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
public class ProductosRepositoryDataTest {

    @Autowired
    private ProductoRepository repo;

    @Test
    void testBeans() {
        assertThat(repo, notNullValue());
    }


    @Test
    public void dadosProductos_cuandogetUserProductsUsuarioEnDB_entoncesProductos() throws Exception {
        List<Producto> productos = repo.findByCompras_Usuario_Uid(1);

        System.out.println(productos);

        assertThat(productos.size(), greaterThan(0));

    }

    @Test
    public void dadosProductos_cuandogetUserProductsUsuarioNoEnDB_entoncesVacio() throws Exception {
        List<Producto> productos = repo.findByCompras_Usuario_Uid(100);

        System.out.println(productos);

        assertThat(productos.size(), is(0));

    }

    @Test
    public void dadoUnProducto_cuandoInserto_entoncesIDvalido() throws Exception {
        Producto prod = new Producto(null, "1567", "marca", "util", 20, 100);

        repo.save(prod);

        assertThat(prod.getPid(), greaterThan(0));
    }

    @Test
    public void dadoUnProductoNoValido_cuandoInserto_entoncesIDvalido() throws Exception {
        Producto prod = new Producto(null, "texto1567", "marca", "util", 20, 100);

        assertThrows(Exception.class, () -> {
            repo.save(prod);
        });
    }

    @Test
    public void dadoUnProducto_cuandoActualizo_entoncesOk() throws RuntimeException {
        Producto prod = repo.findById(1).orElseThrow(()->new RuntimeException());

        String nTipo = "nuevo tipo";
        prod.setTipo(nTipo);

        prod = repo.save(prod);

        assertThat(prod.getTipo(), is(nTipo));
    }

    @Test
    public void dadoUnProducto_cuandoActualizoNoValid_entoncesExcepcion() throws Exception {
        Producto prod = repo.findById(1).orElseThrow(()->new RuntimeException());
        prod.setCodigo("texto");

        assertThrows(Exception.class, () -> {
            repo.save(prod);
        });

    }

    @Test
    public void dadoUnProducto_cuandoElimino_entoncesOk() throws Exception {
        Producto prod = new Producto(12, null, null, null, 0, 0);

        repo.delete(prod);

        assertTrue(true);
    }
}