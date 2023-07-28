package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import es.netmind.mypersonalbankapi.utils.ClienteUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamosController {
    private static List<Prestamo> prestamos;

    static {
        prestamos = new ArrayList<>();
        try {
            prestamos.add(new Prestamo(1, LocalDate.now(), 1000.0, 1000.0, 4, 2, false, false, 2));
            prestamos.add(new Prestamo(2, LocalDate.now(), 100000.0, 100000.0, 4, 2, false, false, 25));

            /* Asociamos préstamos */
            List<Cliente> clientes = ClientesController.clientes;
            clientes.get(0).asociarPrestamo(prestamos.get(0));
            clientes.get(2).asociarPrestamo(prestamos.get(1));

        } catch (Exception e) {
            System.out.println("⚠ Error al crear préstamos: " + e.getMessage());
        }
    }

    public static void mostrarLista(Integer uid) {
        System.out.println("\nLista de préstamos del cliente: " + uid);
        System.out.println("───────────────────────────────────");

        Cliente elCliente = ClienteUtils.encontrarCliente(uid);

        if (elCliente != null)
            if (elCliente.getPrestamos() != null) System.out.println(elCliente.getPrestamos());
            else System.out.println("El cliente no tiene préstamos!");
        else System.out.println("Cliente NO encontrado 😞!");
    }

    public static void mostrarDetalle(Integer uid, Integer aid) {
        System.out.println("\nDetalle de préstamo: " + aid + ", del cliente: " + uid);
        System.out.println("───────────────────────────────────");
        boolean encontrado = false;
        Cliente elCliente = ClienteUtils.encontrarCliente(uid);
        if (elCliente != null && elCliente.getCuentas() != null) {
            for (Prestamo pr : elCliente.getPrestamos()) {
                if (pr.getId().equals(aid)) {
                    System.out.println(pr);
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) System.out.println("Cuenta NO encontrada 😞!");
    }

}
