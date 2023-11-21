package com.coches.gestor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppCollections {

    public static void main(String[] args) {

        List<String> textos = new ArrayList<>();

        System.out.println(textos);

        textos.add("Hola");
        textos.add("que");
        textos.add("tal");
        textos.add("?");

        System.out.println(textos);

        textos.remove(3);
        System.out.println(textos);
        System.out.println(textos.get(2));

        System.out.println("For each...");
        for (String texto : textos) {
            System.out.println(texto);
        }

        System.out.println("Iterador...");
        Iterator<String> it = textos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
