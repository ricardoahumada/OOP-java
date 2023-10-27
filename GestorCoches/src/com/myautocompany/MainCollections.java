package com.myautocompany;

import com.myautocompany.models.Deportivo;
import com.myautocompany.models.Familiar;
import com.myautocompany.models.ICoche;
import com.myautocompany.models.SUV;

import java.util.*;

public class MainCollections {

    public static void main(String[] args) {
        System.out.println("GESTION DE CONJUNTOS DE COCHES");

        final int DISTANCIA = 100;

        List<ICoche> listaCoches = new ArrayList();

        System.out.println(listaCoches.size());

        listaCoches.add(new Deportivo("Porsche", "Deportivo", 120, false));
        listaCoches.add(new Familiar("Renault", "Familiar", 130, 4));
        listaCoches.add(new SUV("Seat", "SUV", 100, 1));

       /* HashMap<String, ICoche> hashCoches = new HashMap<>();
        hashCoches.put("renault", listaCoches.get(1));
        System.out.println(hashCoches.get("renault"));

        hashCoches.put("Renault", listaCoches.get(1));
        System.out.println(hashCoches.get("Renault"));

        hashCoches.put("renault", listaCoches.get(0));
        System.out.println(hashCoches.get("renault"));

        hashCoches.put("seat", listaCoches.get(2));*/

        System.out.println(listaCoches.size());

        ICoche masRapido = null;
        double tMR = 0;
        for (ICoche unCoche : listaCoches) {
            unCoche.arrancar();
            double tC = unCoche.avanzar(DISTANCIA);
            unCoche.parar();

            if (tMR == 0) tMR = tC;

            if (tC <= tMR) {
                masRapido = unCoche;
                tMR = tC;
            }

        }

        System.out.println("El más rápido es:");
        System.out.println(masRapido);

    }

}
