package com.coches.gestor.persistencia;

import com.coches.gestor.modelos.coches.*;
import com.coches.gestor.modelos.motores.Motor;

import java.util.ArrayList;
import java.util.List;

public class CochesRepo {
    private static List<ICoche> coches = new ArrayList<>();

    static {
        ICoche c1 = new Deportivo("Porsche", "Deportivo", 150, false);
        ICoche c2 = new Familiar("Renault", "Familiar", 130, 5);
        ICoche c3 = new SUV("Seat", "SUV", 100, 2);

        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(new Deportivo("Mazda", "Deportivo", 130, true));
        coches.add(new Buggi("Buggi", "buggi", 60, true));

        for (ICoche coche : coches) {
            Motor m = new Motor(7, 100, 6);
            coche.setMotor(m);
        }
    }

    public static List<ICoche> getCoches() {
        return coches;
    }

}
