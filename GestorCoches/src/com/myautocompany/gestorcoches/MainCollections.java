package com.myautocompany.gestorcoches;

import com.myautocompany.gestorcoches.excepciones.MarcaErronea;
import com.myautocompany.gestorcoches.modelos.Coche;
import com.myautocompany.gestorcoches.modelos.ICoche;
import com.myautocompany.gestorcoches.persistencia.InMemoryRepoCoches;
import com.myautocompany.gestorcoches.servicios.ServicioCoches;
import es.netmind.gestorcoches.modelos.*;

import java.util.List;
import java.util.Vector;

public class MainCollections {

    public static void main(String[] args) {
        System.out.println("**** GESTOR DE COCHES ****");

        final int DISTANCIA = 100;

        InMemoryRepoCoches repo = InMemoryRepoCoches.getInstance();

        List<ICoche> cochesList = repo.getAll();


        System.out.println("Lista....");
        System.out.println(cochesList.get(2));
        cochesList.remove(2);
        System.out.println(cochesList.get(2));
        System.out.println("Fin Lista....");


        Vector<ICoche> coches2 = new Vector<>();
        coches2.add(null);
        coches2.add(null);
        coches2.add(null);

        System.out.println("\n--- Coches:");

        Coche.puertas = 2;

        for (ICoche uC : cochesList) {
            System.out.println(uC);
        }

        System.out.println("\n--- Tiempos:");


        ICoche elmr = null;
        try {
            elmr = ServicioCoches.encontrarElMasRapido(cochesList, DISTANCIA);
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