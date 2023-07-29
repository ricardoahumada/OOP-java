package es.netmind.mypersonalbankapi;

import es.netmind.mypersonalbankapi.controladores.ClientesController;
import es.netmind.mypersonalbankapi.controladores.CuentasController;
import es.netmind.mypersonalbankapi.controladores.PrestamosController;
import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import es.netmind.mypersonalbankapi.modelos.cuentas.Ahorro;
import es.netmind.mypersonalbankapi.modelos.cuentas.Corriente;
import es.netmind.mypersonalbankapi.modelos.cuentas.Cuenta;
import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;

import java.time.LocalDate;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════╗");
        System.out.println("║  MY PERSONAL BANK API  ║");
        System.out.println("╚════════════════════════╝");

        try {
            System.out.println("\nClientes:");
            System.out.println("───────────────────────────────────");
            Cliente cl1 = new Personal(1, "Juan Juanez", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J");
            Cliente cl2 = new Empresa(3, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "12345678J", new String[]{"Dev", "Marketing"});

            System.out.println(cl1);
            System.out.println(cl2);

            System.out.println("\nCuentas");
            System.out.println("───────────────────────────────────");
            Cuenta cu1 = new Ahorro(1, LocalDate.now(), 100.0, 1.1, 0.2);
            Cuenta cu2 = new Corriente(1, LocalDate.now(), 200.0, 0.5, 0.2);
            /* Asociamos cuentas */
            cl1.asociarCuenta(cu1);
            cl2.asociarCuenta(cu2);

            System.out.println(cl1);
            System.out.println(cl2);

            System.out.println("\nPréstamos");
            System.out.println("───────────────────────────────────");
            Prestamo pr1 = new Prestamo(1, LocalDate.now(), 1000.0, 1000.0, 4, 2, false, false, 2);
            Prestamo pr2 = new Prestamo(2, LocalDate.now(), 100000.0, 100000.0, 4, 2, false, false, 25);

            /* Asociamos préstamos */
            cl1.asociarPrestamo(pr1);
            cl2.asociarPrestamo(pr2);

            System.out.println(cl1);
            System.out.println(cl2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}