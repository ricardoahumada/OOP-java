package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientesController {

    private static List<Cliente> clientes;

    static {
        clientes = new ArrayList<>();
        try {
            clientes.add(new Personal(1, "Juan Juanez", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J"));
            clientes.add(new Personal(2, "Luisa Perez", "lp@l.com", "Calle LP 2", LocalDate.now(), true, false, "12345678L"));
            clientes.add(new Empresa(3, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "12345678J", new String[]{"Dev", "Marketing"}));

        } catch (Exception e) {
            System.out.println("⚠ Error al crear clientes: " + e.getMessage());
        }
    }

    public static void mostrarLista() {
        System.out.println("\nLista de clientes:");
        System.out.println("───────────────────────────────────");
        for (Cliente cl : clientes) {
            System.out.println(cl);
        }
    }

    public static void mostrarDetalle(Integer uid) {
        System.out.println("\nDetalle de cliente: " + uid);
        System.out.println("───────────────────────────────────");
        boolean encontrado = false;
        for (Cliente cl : clientes) {
            if (cl.getId().equals(uid)) {
                System.out.println(cl);
                encontrado = true;
                break;
            }
        }

        if(!encontrado) System.out.println("Cliente NO encontrado 😞!");
    }
}
