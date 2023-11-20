package com.coches.gestor;

import com.coches.gestor.modelos.coches.Coche;
import com.coches.gestor.modelos.coches.Deportivo;
import com.coches.gestor.modelos.coches.Familiar;
import com.coches.gestor.modelos.coches.SUV;
import com.coches.gestor.modelos.motores.Motor;

public class AppHerencia {
    final static int DISTANCIA = 100;

    public static void main(String[] args) {

        System.out.println("Cargando ....");
        Coche c1 = new Deportivo("Porsche", "Deportivo", 150, false);
        Coche c2 = new Familiar("Renault", "Familiar", 130, 5);
        Coche c3 = new SUV("Seat", "SUV", 100, 2);

        /* parentesis static */
        System.out.println("c1.ruedas: " + c1.ruedas);
        System.out.println("c2.ruedas: " + c2.ruedas);

        c1.ruedas = 5;

        System.out.println("c1.ruedas: " + c1.ruedas);
        System.out.println("c2.ruedas: " + c2.ruedas);

        Coche.ruedas = 3;
        System.out.println("c1.ruedas: " + c1.ruedas);
        System.out.println("c2.ruedas: " + c2.ruedas);

        c1.frenar();
        Coche.frenar();

        String astr = "23";
        Integer anum = new Integer(astr);

        /* cierre parentesis static */

        Motor m1 = new Motor(7, 100, 6);
        Motor m2 = new Motor(9, 120, 9);
        Motor m3 = new Motor(5, 90, 3);

        c1.setMotor(m1);
        c2.setMotor(m2);
        c3.setMotor(m3);

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
