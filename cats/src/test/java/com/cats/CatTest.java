package com.cats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void getName_cuando_use_constructor_vacio() {
        Cat cat = new Cat();
        assertEquals(null, cat.getName());

    }

    @Test
    void getName_cuando_use_constructor_con_parametros() {
        Cat cat = new Cat("misifu");
        assertEquals("misifu", cat.getName());

    }

}