package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.cuentas.Ahorro;
import es.netmind.mypersonalbankapi.modelos.cuentas.Corriente;
import es.netmind.mypersonalbankapi.modelos.cuentas.Cuenta;
import es.netmind.mypersonalbankapi.utils.ClienteUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CuentasController {
    private static List<Cuenta> cuentas;

    static {
        cuentas = new ArrayList<>();
        try {
            cuentas.add(new Ahorro(1, LocalDate.now(), 100.0, 1.1, 0.2));
            cuentas.add(new Corriente(1, LocalDate.now(), 200.0, 0.5, 0.2));
            cuentas.add(new Ahorro(3, LocalDate.now(), 300.0, 1.1, 0.2));

            /* Asociamos cuentas */
            List<Cliente> clientes = ClientesController.clientes;
            clientes.get(0).asociarCuenta(cuentas.get(0));
            clientes.get(1).asociarCuenta(cuentas.get(2));
            clientes.get(2).asociarCuenta(cuentas.get(1));

        } catch (Exception e) {
            System.out.println("⚠ Error al crear cuentas: " + e.getMessage());
        }
    }
    public static void mostrarLista(Integer uid) {
        System.out.println("\nLista de cuentas del cliente: " + uid);
        System.out.println("───────────────────────────────────");

        Cliente elCliente = ClienteUtils.encontrarCliente(uid);

        if (elCliente != null)
            System.out.println(elCliente.getCuentas());
        else System.out.println("Cliente NO encontrado 😞!");
    }

    public static void mostrarDetalle(Integer uid, Integer aid) {
        System.out.println("\nDetalle de cuenta: " + aid + ", del cliente: " + uid);
        System.out.println("───────────────────────────────────");
        boolean encontrado = false;
        Cliente elCliente = ClienteUtils.encontrarCliente(uid);
        if (elCliente != null && elCliente.getCuentas() != null) {
            for (Cuenta cu : elCliente.getCuentas()) {
                if (cu.getId().equals(aid)) {
                    System.out.println(cu);
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) System.out.println("Cuenta NO encontrada 😞!");
    }
}
