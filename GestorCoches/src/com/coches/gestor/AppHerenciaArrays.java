package com.coches.gestor;

import com.coches.gestor.modelos.coches.*;
import com.coches.gestor.modelos.motores.Motor;
import com.coches.gestor.servicios.ServicioCoche;

public class AppHerenciaArrays {
    final static int DISTANCIA = 100;

    public static void main(String[] args) {

        System.out.println("Cargando ....");
        Coche c1 = new Deportivo("Porsche", "Deportivo", 150, false);
        Coche c2 = new Familiar("Renault", "Familiar", 130, 5);
        Coche c3 = new SUV("Seat", "SUV", 100, 2);

        Coche[] coches = {
                c1,
                c2,
                c3,
                new Deportivo("Mazda", "Deportivo", 130, true),
                new Buggi("Buggi", "buggi", 60, true)
        };

        for (int i = 0; i < coches.length; i++) {
            Motor m = new Motor(7, 100, 6);
            coches[i].setMotor(m);
        }


        System.out.println("Simulando ....");
        Coche masRapido = ServicioCoche.encontrarElMasRapido(coches, DISTANCIA);


        System.out.println("El coche más rápido es:");
        System.out.println(masRapido);

    }

}
