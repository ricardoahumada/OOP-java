package com.coches.gestor;

import com.coches.gestor.exceptions.MotorException;
import com.coches.gestor.modelos.coches.*;
import com.coches.gestor.modelos.motores.Motor;
import com.coches.gestor.persistencia.CochesRepo;
import com.coches.gestor.servicios.ServicioCoche;

import java.util.ArrayList;
import java.util.List;

public class AppHerenciaColeccionesInterfaces {

    final static int DISTANCIA = 100;

    public static void main(String[] args) {

        System.out.println("Cargando ....");
        List<ICoche> coches = CochesRepo.getCoches();

        System.out.println("Simulando ....");

        try {
            ICoche masRapido = ServicioCoche.encontrarElMasRapido(coches, DISTANCIA);
            System.out.println("El coche más rápido es:");
            System.out.println(masRapido);
        } catch (NullPointerException e) {
            System.out.println("Ha habido un error...inténtelo más tarde");
        } catch (MotorException e) {
            System.out.println("Ha habido un error..." + e.getMessage());
        } catch (Exception e) {
            // pedir revision
            System.out.println("Exceptiom general....");
        }

    }

}
