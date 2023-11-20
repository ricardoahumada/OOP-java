package com.coches.gestor.servicios;

import com.coches.gestor.modelos.coches.Coche;

public class ServicioCoche {

    public static Coche encontrarElMasRapido(Coche[] coches, int distancia) {
        double[] tiempos = new double[coches.length];
        for (int i = 0; i < coches.length; i++) {
            coches[i].arrancar();
            tiempos[i] = coches[i].avanzar(distancia);
            coches[i].parar();
        }

        System.out.println("Calculando ....");
        Coche masRapido = null;
        double tiempoMenor = Double.POSITIVE_INFINITY;
        for (int i = 0; i < tiempos.length; i++) {
            if (tiempos[i] < tiempoMenor) {
                tiempoMenor = tiempos[i];
                masRapido = coches[i];
            }
        }

        return masRapido;
    }

}
