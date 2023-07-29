package es.netmind.mypersonalbankapi;

import es.netmind.mypersonalbankapi.controladores.ClientesController;
import es.netmind.mypersonalbankapi.controladores.CuentasController;
import es.netmind.mypersonalbankapi.controladores.PrestamosController;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════╗");
        System.out.println("║  MY PERSONAL BANK API  ║");
        System.out.println("╚════════════════════════╝");

        if (args != null && args.length >= 2) {
            try {
                procesarArgumentos(args);
            } catch (NumberFormatException e) {
                System.out.println("⚠ LOS IDENTIFICADORES DE CLIENTE {uid}, CUENTA {aid} Y PRÉSTAMOS {lid} DEBEN SER NÚMEROS ⚠");
                mostrarInstrucciones();
            } catch (Exception e) {
                System.out.println("⚠ HA HABIDO UN ERROR... CONTACTE CON EL ADMINISTRADOR ⚠");
                e.printStackTrace();
            }

        } else mostrarInstrucciones();

    }

    private static void procesarArgumentos(String[] args) {
        int argsLength = args.length;
        String arg0 = args[0].toLowerCase();
        String arg1 = args[1].toLowerCase();

        if (!arg0.equals("clients")) {
            mostrarInstrucciones();
            return;
        }

        if (argsLength == 2) {
            if (arg1.equals("list")) ClientesController.mostrarLista();
            else ClientesController.mostrarDetalle(Integer.valueOf(arg1));
        } else if (argsLength >= 3) {
            int uid = Integer.valueOf(arg1);
            String arg2 = args[2].toLowerCase();
            if (arg2.equals("accounts") && argsLength == 3) CuentasController.mostrarLista(uid);
            else if (arg2.equals("accounts")) CuentasController.mostrarDetalle(uid, Integer.valueOf(args[3]));
            else if (arg2.equals("loans") && argsLength == 3) PrestamosController.mostrarLista(uid);
            else if (arg2.equals("loans")) PrestamosController.mostrarDetalle(uid, Integer.valueOf(args[3]));
        } else mostrarInstrucciones();
    }

    private static void mostrarInstrucciones() {
        System.out.println("⚠ LAS OPCIONES DEL PROGRAMA SON LAS SIGUIENTES: ⚠");
        System.out.println("clients list");
        System.out.println("clients {uid}");
        System.out.println("clients {uid} accounts");
        System.out.println("clients {uid} accounts {aid}");
        System.out.println("clients {uid} loans");
        System.out.println("clients {uid} loans {lid}");
    }
}