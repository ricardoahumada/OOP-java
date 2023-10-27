package com.myautocompany;

import com.myautocompany.models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("GESTOR COCHES");

        final int DISTANCIA = 100;

        ICoche porsche = new Deportivo("Porsche", "Deportivo", 120, true);
        ICoche renault = new Familiar("Renault", "Familiar", 130, 4);
        ICoche seat = new SUV("Seat", "SUV", 100, 1);

        System.out.println(porsche);
        System.out.println(renault);

        porsche.arrancar();
        renault.arrancar();
        seat.arrancar();

        double t1 = porsche.avanzar(DISTANCIA);
        double t2 = renault.avanzar(DISTANCIA);
        double t3 = seat.avanzar(DISTANCIA);

        porsche.parar();
        renault.parar();
        seat.parar();

        ICoche masRapido = null;
        if (t1 < t2 && t1 < t3) masRapido = porsche;
        else if (t2 < t1 && t2 < t3) masRapido = renault;
        else if (t3 < t1 && t3 < t2) masRapido = seat;

        System.out.println("El más rápido es:");
        System.out.println(masRapido);
    }
}