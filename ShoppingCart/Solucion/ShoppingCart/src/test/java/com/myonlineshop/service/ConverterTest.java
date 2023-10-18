package com.myonlineshop.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "-2", "2", "000"})
    void dada_cadenaBienFormada_cuando_convert_entonces_int(String texto) {
        Integer num = Converter.convert(texto);

        assertTrue(num instanceof Integer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hola", "-2x", "2x"})
    void dada_cadenaMalFormada_cuando_convert_entonces_excepcion(String texto) {
        assertThrows(NumberFormatException.class, () -> {
            Integer num = Converter.convert(texto);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100000", "-32769", "-32769", "100000"})
    void dado_rangoincorrecto_cuando_convert_entonces_excepcion(String texto) {
        assertThrows(Exception.class, () -> {
            Integer num = Converter.convert(texto);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-32768", "-2", "2", "32767"})
    void dado_rangocorrecto_cuando_convert_entonces_int(String texto) {
        Integer num = Converter.convert(texto);
        assertTrue(num instanceof Integer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1.2", "1.2", "0.0"})
    void dado_real_cuando_convert_entonces_excepcion(String texto) {
        assertThrows(Exception.class, () -> {
            Integer num = Converter.convert(texto);
        });

    }

}