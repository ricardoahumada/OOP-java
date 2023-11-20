package com.coches.gestor;

import com.coches.gestor.modelos.Coche;
import com.coches.gestor.modelos.Deportivo;
import com.coches.gestor.modelos.Familiar;
import com.coches.gestor.modelos.SUV;

public class AppHerencia {
    final static int DISTANCIA = 100;

    public static void main(String[] args) {

        System.out.println("Cargando ....");
        Coche c1 = new Deportivo("Porsche", "Deportivo", 150, false);
        Coche c2 = new Familiar("Renault", "Familiar", 130,5);
        Coche c3 = new SUV("Seat", "SUV", 100, 2);

        System.out.println("Arrancando ....");
        c1.arrancar();
        c2.arrancar();
        c3.arrancar();

        System.out.println("Simulando ....");
        double t1 = c1.avanzar(DISTANCIA);
        double t2 = c2.avanzar(DISTANCIA);
        double t3 = c3.avanzar(DISTANCIA);

        System.out.println("Calculando ....");
        Coche masRapido = null;

        if (t1 < t2 && t1 < t3) masRapido = c1;
        else if (t2 < t1 && t2 < t3) masRapido = c2;
        else if (t3 < t1 && t3 < t2) masRapido = c3;

        c1.parar();
        c2.parar();
        c3.parar();

        System.out.println("El coche más rápido es:");
        System.out.println(masRapido);

    }

}
