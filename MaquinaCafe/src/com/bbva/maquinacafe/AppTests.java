package com.bbva.maquinacafe;

import com.bbva.maquinacafe.modelos.Capsula;

public class AppTests {
    public static void main(String[] args) {
        int[] los_numeros_1 = {1, 2, 3};
        int[] los_numeros_2 = new int[3];

        String[] textos = {"hola", "que", "tal?"};

        Capsula[] capsulas = {new Capsula(), new Capsula(1, "Bonka", "expresso"), new Capsula()};

        System.out.println("a1:" + los_numeros_1.length);
        System.out.println("s2:" + los_numeros_2.length);
        System.out.println("a3:" + textos.length);
        System.out.println("a4:" + capsulas.length);

        System.out.println("a1 1:" + los_numeros_1[1]);
        System.out.println("a2 1:" + los_numeros_2[1]);
        System.out.println("a3 1:" + textos[1]);
        System.out.println("a4 1:" + capsulas[1]);

        capsulas[1].calcular_precio();
        System.out.println("a4 1:" + capsulas[1]);

        System.out.println("------------------------------------------");

        if (capsulas.length > 2) System.out.println("Es mayor que 2");
        else System.out.println("Es menor que 2");

        if (capsulas[1].getPrecio() > 3 && capsulas[1].getPrecio() < 6) {
            int val = 3;
            System.out.println("El precio es mayor que " + val);
        } else if (capsulas[1].getPrecio() > 6 && capsulas[1].getPrecio() < 10) {
            System.out.println("El precio es mayor que 6");
        } else {
            System.out.println("El precio es menor que 3");
        }


        int unValor = 5;
        switch (unValor) {
            case 1:
                System.out.println("evaluando....");
                System.out.println("vale 1");
                break;
            case 2:
                System.out.println("evaluando....");
                System.out.println("vale 2");
                break;
            case 3:
                System.out.println("evaluando....");
                System.out.println("vale 3");
                break;
            case 4:
                System.out.println("evaluando....");
                System.out.println("vale 4");
                break;
            default:
                System.out.println("evaluando....");
                System.out.println("vale default");
        }

    }
}
