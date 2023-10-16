package com.cats;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatServiceTest {

    @Test
    void dado_listaGatosConNombre_cuandoconcatCats_entoncesStringNPuntos() {
        // dado
        List<Cat> catsAProbar = new ArrayList<>();
        catsAProbar.add(new Cat("misifu"));
        catsAProbar.add(new Cat("miau"));
        catsAProbar.add(new Cat("cesar"));

        // cuando
        String valor = CatService.concatCats(catsAProbar);
        System.out.println("valor:"+valor);

        // entonces
        String[] elems = valor.split(":");
        assertEquals(catsAProbar.size(), elems.length);

        for (int i = 0; i < catsAProbar.size(); i++) {
            assertTrue(valor.contains(catsAProbar.get(i).getName()));
        }

    }

}