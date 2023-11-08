package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ProductosDBRepositoryTest {

    private IProductoRepository repo;

    @BeforeEach
    void sepUp() throws IOException {
        repo = new ProductoDBRepository();
    }

    @Test
    public void dadosProductos_cuandogetUserProductsUsuarioEnDB_entoncesProductos() throws Exception {
        List<Producto> productos = repo.getUserProducts(1);

        System.out.println(productos);

        assertThat(productos.size(), greaterThan(0));

    }

    @Test
    public void dadosProductos_cuandogetUserProductsUsuarioNoEnDB_entoncesVacio() throws Exception {
        List<Producto> productos = repo.getUserProducts(100);

        System.out.println(productos);

        assertThat(productos.size(), is(0));

    }

    @Test
    public void dadosunProducto_cuandoInserto_entoncesIDvalido() throws Exception {
        Producto prod = new Producto(null, "prod1", "marca", "util", 20, 100);

        repo.insertarProducto(prod);

        assertThat(prod.getMid(), greaterThan(0));
    }
}
