package com.myautocompany.gestorcoches.servicios;

import com.myautocompany.gestorcoches.excepciones.MarcaErronea;
import com.myautocompany.gestorcoches.modelos.ICoche;

import java.util.Collection;
import java.util.Iterator;


public class ServicioCoches {

    public static ICoche encontrarElMasRapido(ICoche[] listaCoches, int distancia) throws NullPointerException, MarcaErronea, Exception {

        ICoche masRapido = null;

        try {
            double tMR = 0;
            for (ICoche uC : listaCoches) {
                // System.out.println(uC);

                if (!uC.validar()) {
                    throw new MarcaErronea("La marca es incorrecta");
                }

                uC.arrancar();
                double tA = uC.avanzar(distancia);
                if (tMR == 0) {
                    tMR = tA;
                    masRapido = uC;
                } else {
                    if (tA < tMR) {
                        tMR = tA;
                        masRapido = uC;
                    }
                }
                uC.parar();
            }

            return masRapido;
        } catch (NullPointerException e) {
            System.out.println("... ha fallado en encontrarElMasRapido: nulo");
            throw new NullPointerException();
        } catch (Exception e) {
            System.out.println("... ha fallado en encontrarElMasRapido: " + e.getMessage());
            // aviaar admin
            throw e;
        } /*finally {
            System.out.println("Bloque finally...");
            //   return masRapido;
        }*/

    }

    public static ICoche encontrarElMasRapido(Collection<ICoche> listaCoches, int distancia) throws NullPointerException, MarcaErronea, Exception {
        ICoche masRapido = null;

        try {
            double tMR = 0;
            Iterator<ICoche> itrCoches = listaCoches.iterator();
            while (itrCoches.hasNext()) {
                ICoche uC = itrCoches.next();
                /*if (!uC.validar()) {
                    throw new MarcaErronea("La marca es incorrecta");
                }*/
                uC.arrancar();
                double tA = uC.avanzar(distancia);
                if (tMR == 0) {
                    tMR = tA;
                    masRapido = uC;
                } else {
                    if (tA < tMR) {
                        tMR = tA;
                        masRapido = uC;
                    }
                }
                uC.parar();
            }

            return masRapido;
        } catch (NullPointerException e) {
            System.out.println("... ha fallado en encontrarElMasRapido: nulo");
            throw new NullPointerException();
        } catch (Exception e) {
            System.out.println("... ha fallado en encontrarElMasRapido: " + e.getMessage());
            // aviaar admin
            throw e;
        }
    }

}

