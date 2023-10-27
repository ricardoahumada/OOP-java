package com.mymotorcompany.simuladorcoches.servicios;

import com.mymotorcompany.simuladorcoches.excepciones.CocheException;
import com.mymotorcompany.simuladorcoches.modelos.coches.ICoche;

import java.util.Collection;

public class ServicioCoches {

    public static ICoche encontrarMasRapido(ICoche[] listaC, int distancia) throws NullPointerException, CocheException, Exception {
        ICoche masRapido = null;
        double tiempoMenor = Double.POSITIVE_INFINITY;
        try {
            for (ICoche unC : listaC) {
                unC.validar();
                unC.arrancar();
                double tActual = unC.avanzar(distancia);
                unC.parar();

                if (tActual < tiempoMenor) {
                    tiempoMenor = tActual;
                    masRapido = unC;
                }
            }

            return masRapido;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Enviando mensaje admin sobre error: " + e.getMessage());
            throw e;
        }
    }

    public static ICoche encontrarMasRapido(Collection<ICoche> listaC, int distancia) throws NullPointerException, CocheException, Exception {
        ICoche masRapido = null;
        double tiempoMenor = Double.POSITIVE_INFINITY;
        try {
            for (ICoche unC : listaC) {
                unC.validar();
                unC.arrancar();
                double tActual = unC.avanzar(distancia);
                unC.parar();

                if (tActual < tiempoMenor) {
                    tiempoMenor = tActual;
                    masRapido = unC;
                }
            }

            return masRapido;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Enviando mensaje admin sobre error: " + e.getMessage());
            throw e;
        }
    }
}
