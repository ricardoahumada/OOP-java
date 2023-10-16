package com.cats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void dado_gatoSINnombre_cuando_maullar_estonces_miaunull() {
        //dado
        Cat cat = new Cat();

        //cuando
        String valor = cat.maullar();

        // entonces
        assertEquals("miau: null", valor);
    }

    @Test
    void dado_gatoCONnombre_cuando_maullar_estonces_miaunombre() {
        //dado
        String misifu = "misifu";
        Cat cat = new Cat(misifu);

        //cuando
        String valor = cat.maullar();

        // entonces
        assertEquals("miau: " + misifu, valor);
    }

}