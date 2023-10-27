package com.myautocompany.gestorcoches;

import com.myautocompany.gestorcoches.excepciones.MarcaErronea;
import com.myautocompany.gestorcoches.modelos.*;
import com.myautocompany.gestorcoches.servicios.ServicioCoches;
import es.netmind.gestorcoches.modelos.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("**** GESTOR DE COCHES ****");

        final int DISTANCIA = 100;

        ICoche[] coches = {
                new Deportivo("Porsche", "Deportivo", 120, true),
                new Familiar("Renault", "Familiar", 130, 4),
                new SUV("Seat", "SUV", 100, 1),
                new Limusina("Limo", "Limunsine", 90, 2)
        };

        ICoche[] coches2 = {
                null, null, null
        };

        System.out.println("\n--- Coches:");

        Coche.puertas = 2;

        for (ICoche uC : coches) {
            System.out.println(uC);
        }

        System.out.println("\n--- Tiempos:");


        ICoche elmr = null;
        try {
            elmr = ServicioCoches.encontrarElMasRapido(coches, DISTANCIA);
            System.out.println("El más rápido es:");
            System.out.println(elmr);
        } catch (MarcaErronea e) {
            System.out.println("Revisa las marcas:" + e.getMessage());
            //aviasar admin
        } catch (NullPointerException e) {
            System.out.println("Revisa los coches que has pasado al sistema!!!");
            //aviasar admin
        } catch (Exception e) {
            System.out.println("Opps...ha habido un error, vuelve a intarlo");
            //aviasar admin
        }

        //if (elmr != null) System.out.println(elmr);
        //else System.out.println("Ooopss...ha habido un error");
    }


}