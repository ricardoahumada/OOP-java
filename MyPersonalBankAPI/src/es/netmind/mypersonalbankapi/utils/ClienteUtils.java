package es.netmind.mypersonalbankapi.utils;

import es.netmind.mypersonalbankapi.controladores.ClientesController;
import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;

public class ClienteUtils {
    public final static Cliente encontrarCliente(Integer uid) {
        if (ClientesController.clientes != null) {
            for (Cliente cl : ClientesController.clientes) {
                if (uid == cl.getId()) {
                    return cl;
                }
            }
        }
        return null;
    }
}
