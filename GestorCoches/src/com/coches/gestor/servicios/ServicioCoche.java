package com.coches.gestor.servicios;

import com.coches.gestor.modelos.coches.Coche;
import com.coches.gestor.modelos.coches.ICoche;

import java.util.Collection;
import java.util.List;

public class ServicioCoche {

    public static ICoche encontrarElMasRapido(ICoche[] coches, int distancia) throws Exception {
        ICoche masRapido = null;

        try {
            double[] tiempos = new double[coches.length];
            for (int i = 0; i < coches.length; i++) {
                System.out.println("procesando " + i);
//            try {
                coches[i].arrancar();
                tiempos[i] = coches[i].avanzar(distancia);
                coches[i].parar();
            /*} catch (Exception ex) {
                System.out.println("Avisar al admin!!!! " + ex.getMessage());
            }*/

            }

            System.out.println("Calculando ....");
            double tiempoMenor = Double.POSITIVE_INFINITY;
            for (int i = 0; i < tiempos.length; i++) {
                if (tiempos[i] < tiempoMenor) {
                    tiempoMenor = tiempos[i];
                    masRapido = coches[i];
                }
            }

        } catch (Exception ex) {
            System.out.println("Avisar al admin!!!! " + ex.getMessage());
            throw ex;
        }

        return masRapido;
    }

    public static ICoche encontrarElMasRapido(Collection<ICoche> coches, int distancia) throws Exception {

        ICoche masRapido = null;

        try {
            System.out.println("Calculando ....");
            double tiempoMenor = Double.POSITIVE_INFINITY;

            for (ICoche coche : coches) {
                System.out.println("procesando: " + coche);
                coche.arrancar();
                double tiempoAct = coche.avanzar(distancia);
                if (tiempoAct < tiempoMenor) {
                    tiempoMenor = tiempoAct;
                    masRapido = coche;
                }
                coche.parar();
            }

        } catch (Exception ex) {
            System.out.println("Avisar al admin!!!! " + ex.getMessage());
            throw ex;
        }

        return masRapido;
    }

}

