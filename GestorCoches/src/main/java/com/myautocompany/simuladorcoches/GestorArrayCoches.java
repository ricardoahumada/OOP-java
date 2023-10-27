package com.myautocompany.simuladorcoches;

import com.myautocompany.simuladorcoches.modelos.coches.ICoche;
import com.myautocompany.simuladorcoches.excepciones.CocheException;
import com.myautocompany.simuladorcoches.persistencia.CochesRepositorio;
import com.myautocompany.simuladorcoches.servicios.ServicioCoches;

import java.util.List;

public class GestorArrayCoches {

    static int DISTANCIA = 100;

    public static void main(String[] args) {
        System.out.println("SIMULADOR DE COCHES");

        try {
            DISTANCIA = new Integer(args[0]);
            System.out.println("Distania correcta: " + DISTANCIA);
        } catch (NumberFormatException ex) {
            System.out.println("Distancia incorecta, continuamos con el:" + DISTANCIA);
        } catch (Exception ex) {
            System.out.println("Ha habido un error");
            return;
        }

        System.out.println("Cargando ....");

        List<ICoche> listaCoches = CochesRepositorio.getAll();

        ICoche masRapido = null;
        try {
            masRapido = ServicioCoches.encontrarMasRapido(listaCoches, DISTANCIA);
            System.out.println("El coche más rápido es:");
            System.out.println(masRapido);
        } catch (CocheException e) {
            System.out.println("Uno de los coches no es válido" + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("La lista de coches está vacia :-( " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ooops ... ha habido un error :-(" + e.getMessage());
        }


    }


}
