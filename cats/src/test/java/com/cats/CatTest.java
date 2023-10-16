package com.cats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CatTest {

    @Test
    void dado_gatoSINnombre_cuando_getname_estonces_esNulo() {
        //dado
        Cat cat = new Cat();

        //cuando
        String nombre = cat.getName();

        // entonces
//        assertEquals(null, nombre);
        assertNull(nombre);
    }

    @Test
    void dado_gatoCONnombre_cuando_getname_estonces_tieneValor() {
        //dado
        Cat cat = new Cat("misifu");

        //cuando
        String nombre = cat.getName();

        // entonces
        assertEquals("misifu", nombre);
    }

    @Test
    void dado_gatoSINnombre_cuando_maullar_estonces_lanzaExcepcion() {
        //dado
        Cat cat = new Cat();

        // entonces
        assertThrows(NullPointerException.class, () -> {
            //cuando
            cat.maullar();
        });

    }

    @ParameterizedTest
    @ValueSource(strings = {"misifu", "cleopatra", "cesarycleopatra________________________________"})
    void dado_valoresCorretos_cuando_maullar_estonces_miauNombreMayusculas(String nombre) {
        //dado
        Cat cat = new Cat(nombre);

        //cuando
        String valor = cat.maullar();

        // entonces
        // assertEquals("miau: " + nombre.toUpperCase(), valor);
        assertThat(valor, is("miau: " + nombre.toUpperCase()));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "mix"})
    void dado_valoresNoValidos_cuando_maullar_estonces_lanzaExcepcion(String nombre) {
        //dado
        Cat cat = new Cat(nombre);

        // entonces
        assertThrows(NullPointerException.class, () -> {
            //cuando
            cat.maullar();
        });

    }

}