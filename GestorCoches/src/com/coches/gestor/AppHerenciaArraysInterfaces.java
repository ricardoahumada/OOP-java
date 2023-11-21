package com.coches.gestor;

import com.coches.gestor.exceptions.MotorException;
import com.coches.gestor.modelos.coches.*;
import com.coches.gestor.modelos.motores.Motor;
import com.coches.gestor.servicios.ServicioCoche;

public class AppHerenciaArraysInterfaces {
    final static int DISTANCIA = 100;

    public static void main(String[] args) {

        System.out.println("Cargando ....");
        ICoche c1 = new Deportivo("Porsche", "Deportivo", 150, false);
        ICoche c2 = new Familiar("Renault", "Familiar", 130, 5);
        ICoche c3 = new SUV("Seat", "SUV", 100, 2);

        ICoche[] coches = {
                c1,
                c2,
                c3,
                new Deportivo("Mazda", "Deportivo", 130, true),
                new Buggi("Buggi", "buggi", 60, true)
        };

        for (int i = 0; i < coches.length; i++) {
            Motor m = new Motor(7, 100, 6);
            if (i != 2) coches[i].setMotor(m);
        }


        System.out.println("Simulando ....");
//        coches = null;

        try {
            ICoche masRapido = ServicioCoche.encontrarElMasRapido(coches, DISTANCIA);
            System.out.println("El coche más rápido es:");
            System.out.println(masRapido);
        } catch (NullPointerException e) {
            System.out.println("Ha habido un error...inténtelo más tarde");
        } catch (MotorException e) {
            System.out.println("Ha habido un error..." + e.getMessage());
        } catch (Exception e) {
            // pedir revision
            System.out.println("Exceptiom general....");
        }

    }

}
