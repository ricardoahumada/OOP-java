package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.modelos.cuentas.Cuenta;
import es.netmind.mypersonalbankapi.persistencia.CuentasInMemoryRepo;
import es.netmind.mypersonalbankapi.persistencia.ICuentasRepo;

import java.util.List;

public class CuentasController {
    private static ICuentasRepo cuentasRepo = CuentasInMemoryRepo.getInstance();

    public static void mostrarLista(Integer uid) {
        System.out.println("\nLista de cuentas del cliente: " + uid);
        System.out.println("───────────────────────────────────");

        try {
            List<Cuenta> cuentas = cuentasRepo.getAccountsByClient(uid);
            if (cuentas != null && cuentas.size() > 0) System.out.println(cuentas);
            else System.out.println("El cliente no tiene cuentas!");
        } catch (Exception e) {
            System.out.println("Cliente NO encontrado 😞!");
        }
    }

    public static void mostrarDetalle(Integer uid, Integer aid) {
        System.out.println("\nDetalle de cuenta: " + aid + ", del cliente: " + uid);
        System.out.println("───────────────────────────────────");

        try {
            Cuenta cuenta = cuentasRepo.getAccountsByClientAndId(uid, aid);
            System.out.println(cuenta);
        } catch (Exception e) {
            System.out.println("Cuenta NO encontrada para el cliente 😞!");
        }
    }
}
