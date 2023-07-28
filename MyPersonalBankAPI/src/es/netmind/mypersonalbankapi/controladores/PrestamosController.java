package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class PrestamosController {
    private static List<Prestamo> prestamos;

    static {
        prestamos = new ArrayList<>();
        try {
            prestamos.add(null);

        } catch (Exception e) {
            System.out.println("⚠ Error al crear préstamos: " + e.getMessage());
        }
    }

    public static void mostrarLista(Integer uid) {
        System.out.println("\nLista de préstamos del cliente: " + uid);
        System.out.println("───────────────────────────────────");
        for (Prestamo pr : prestamos) {
            System.out.println(pr);
        }
    }

    public static void mostrarDetalle(Integer uid, Integer lid) {
        System.out.println("\nDetalle de préstamo: " + lid + ", del cliente: " + uid);
        System.out.println("───────────────────────────────────");
        boolean encontrado = false;
        for (Prestamo pr : prestamos) {
            if (pr.getId().equals(lid)) {
                System.out.println(pr);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) System.out.println("Préstamo NO encontrada 😞!");
    }

}
