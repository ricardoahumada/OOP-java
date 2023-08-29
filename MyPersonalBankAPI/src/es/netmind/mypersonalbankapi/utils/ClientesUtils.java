package es.netmind.mypersonalbankapi.utils;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;

import java.time.LocalDate;

public class ClientesUtils {
    public static Cliente extractClientFromArgsForCreate(String[] args) throws Exception {
        int argsLength = args.length;

        Cliente cl = null;
        if (args[0].toLowerCase().equals("personal")) {
            cl = new Personal(null, args[1], args[2], args[3], LocalDate.parse(args[4]), true, false, args[5]);
        } else if (args[0].toLowerCase().equals("empresa")) {
            cl = new Empresa(null, args[1], args[2], args[3], LocalDate.parse(args[4]), true, false, args[5], argsLength > 8 ? args[8].split(",") : null);
        }

        return cl;
    }


    public static Cliente updateClientFromArgs(Cliente cliente, String[] args) throws Exception {
        // {nombre} {email} {direccion} {fechaAlta (yyyy-mm-dd)} {activo} {moroso} {dni/nif} {unidadesNegocio (opcional)}

        int argsLength = args.length;

        String className = cliente.getClass().getName();

        if (args[0] != null) cliente.setNombre(args[0]);
        if (args[1] != null) cliente.setEmail(args[1]);
        if (args[2] != null) cliente.setDireccion(args[2]);
        if (args[3] != null) cliente.setAlta(LocalDate.parse(args[3]));
        if (args[4] != null) cliente.setActivo(Boolean.valueOf(args[4]));
        if (args[5] != null) cliente.setMoroso(Boolean.valueOf(args[5]));

        if (className.contains("modelos.clientes.personal")) {
            Personal per = (Personal) cliente;
            if (args[6] != null) per.setDni(args[6]);

            return per;
        } else {
            Empresa emp = (Empresa) cliente;
            if (args[6] != null) emp.setCif(args[6]);
            if (argsLength > 7) emp.setUnidadesNegocio(args[7].split(","));

            return emp;
        }


    }
}
