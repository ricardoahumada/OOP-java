package es.netmind.simuladorcoches.persistencia;

import es.netmind.simuladorcoches.modelos.coches.*;
import es.netmind.simuladorcoches.modelos.coches.ICoche;
import es.netmind.simuladorcoches.modelos.motores.Combustion;
import es.netmind.simuladorcoches.modelos.motores.Electrico;

import java.util.ArrayList;
import java.util.List;

public class CochesRepositorio {

    private static List<ICoche> lista = new ArrayList<>();

    static {
        // crear coches
        lista.add(new Deportivo("Porsche", "Deportivo", 120, false));
        lista.add(new Familiar("Renault", "Familiar", 130, 5));
        lista.add(new SUV("Seat", "SUV", 100, 1));

        // asociar motores
        lista.get(0).setMotor(new Combustion(1, 90));
        lista.get(1).setMotor(new Electrico(2, 120));
        lista.get(2).setMotor(new Combustion(3, 130));
    }

    public static List<ICoche> getAll() {
        return lista;
    }

    public static boolean add(ICoche c1) {
        lista.add(c1);
        return true;
    }

    public static boolean remove(ICoche c1) {
        lista.remove(c1);
        return true;
    }

    public static boolean remove(int idx) {
        lista.remove(idx);
        return true;
    }


}
