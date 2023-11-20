package com.coches.gestor.servicios;

import com.coches.gestor.modelos.coches.Coche;

public class ServicioCoche {

    public static Coche encontrarElMasRapido(Coche[] coches, int distancia) throws Exception{
        Coche masRapido = null;

        try {
            double[] tiempos = new double[coches.length];
            for (int i = 0; i < coches.length; i++) {
                coches[i].arrancar();
                tiempos[i] = coches[i].avanzar(distancia);
                coches[i].parar();
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

}
