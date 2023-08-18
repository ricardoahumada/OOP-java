package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.exceptions.ClienteException;
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
            } catch (ClienteException e) {
                System.out.println("El cliente solicitado tiene datos erroneos 😞! Ponte en contacto con el admin. \nCode: " + e.getCode());
            } catch (Exception e) {
                System.out.println("Oops ha habido un problema, inténtelo más tarde 😞!");
            }

        }
    }

    public static void mostrarDetalle(Integer uid) {
        System.out.println("\nDetalle de cliente: " + uid);
        System.out.println("───────────────────────────────────");

        try {
            Cliente cl = clientesRepo.getClientById(uid);
            System.out.println(cl);
        } catch (ClienteException e) {
            System.out.println("Cliente NO encontrado 😞! \nCode: " + e.getCode());
        } catch (Exception e) {
            System.out.println("Oops ha habido un problema, inténtelo más tarde 😞!");
        }

    }
}
