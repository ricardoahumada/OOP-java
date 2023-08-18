package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.exceptions.PrestamoException;
import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import es.netmind.mypersonalbankapi.persistencia.IPrestamosRepo;
import es.netmind.mypersonalbankapi.persistencia.PrestamosInMemoryRepo;

import java.util.List;

public class PrestamosController {
    private static IPrestamosRepo prestamosRepo = PrestamosInMemoryRepo.getInstance();

    public static void mostrarLista(Integer uid) {
        System.out.println("\nLista de prestamos del cliente: " + uid);
        System.out.println("───────────────────────────────────");

        try {
            List<Prestamo> prestamos = prestamosRepo.getLoansByClient(uid);
            if (prestamos != null && prestamos.size() > 0) System.out.println(prestamos);
            else System.out.println("El cliente no tiene prestamos!");
        } catch (PrestamoException e) {
            System.out.println("Cliente NO encontrado 😞! \nCode: " + e.getCode());
        } catch (Exception e) {
            System.out.println("Oops ha habido un problema, inténtelo más tarde 😞!");
        }
    }

    public static void mostrarDetalle(Integer uid, Integer aid) {
        System.out.println("\nDetalle de cuenta: " + aid + ", del cliente: " + uid);
        System.out.println("───────────────────────────────────");

        try {
            Prestamo cuenta = prestamosRepo.getLoansByClientAndId(uid, aid);
            System.out.println(cuenta);
        } catch (PrestamoException e) {
            System.out.println("Prestamo NO encontrado para el cliente 😞! \nCode: " + e.getCode());
        } catch (Exception e) {
            System.out.println("Oops ha habido un problema, inténtelo más tarde 😞!");
        }
    }

}
