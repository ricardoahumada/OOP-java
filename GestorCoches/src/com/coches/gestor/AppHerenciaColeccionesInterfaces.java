package com.coches.gestor;

import com.coches.gestor.exceptions.MotorException;
import com.coches.gestor.modelos.coches.*;
import com.coches.gestor.modelos.motores.Motor;
import com.coches.gestor.servicios.ServicioCoche;

import java.util.ArrayList;
import java.util.List;

public class AppHerenciaColeccionesInterfaces {


    final static int DISTANCIA = 100;

    public static void main(String[] args) {

        System.out.println("Cargando ....");
        ICoche c1 = new Deportivo("Porsche", "Deportivo", 150, false);
        ICoche c2 = new Familiar("Renault", "Familiar", 130, 5);
        ICoche c3 = new SUV("Seat", "SUV", 100, 2);

        List<ICoche> coches = new ArrayList<>();
        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(new Deportivo("Mazda", "Deportivo", 130, true));
        coches.add(new Buggi("Buggi", "buggi", 60, true));

        for (ICoche coche : coches) {
            Motor m = new Motor(7, 100, 6);
            coche.setMotor(m);
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
