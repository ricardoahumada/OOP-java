package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.persistencia.ClientesInMemoryRepo;
import es.netmind.mypersonalbankapi.persistencia.IClientesRepo;

import java.util.List;

public class ClientesController {

    private static IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();

    public static void mostrarLista() {
        System.out.println("\nLista de clientes:");
        System.out.println("───────────────────────────────────");
        List<Cliente> clientes = clientesRepo.getAll();
        for (Cliente cl : clientes) {

            try {
                cl.validar();
                System.out.println(cl);
            } catch (Exception e) {
                System.out.println("El cliente solicitado tiene datos erroneos, ponerse en contacto con el admin.");
            }

        }
    }

    public static void mostrarDetalle(Integer uid) {
        System.out.println("\nDetalle de cliente: " + uid);
        System.out.println("───────────────────────────────────");
        Cliente cl = clientesRepo.getClientById(uid);
        if (cl != null) {
            System.out.println(cl);
        } else System.out.println("Cliente NO encontrado 😞!");
    }
}
