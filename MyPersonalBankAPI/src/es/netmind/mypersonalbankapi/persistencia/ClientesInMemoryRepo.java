package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientesInMemoryRepo implements IClientesRepo {
    private static ClientesInMemoryRepo instance;
    private final static List<Cliente> clientes;

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

    private ClientesInMemoryRepo() {
    }

    public static ClientesInMemoryRepo getInstance() {
        if (instance == null) instance = new ClientesInMemoryRepo();
        return instance;
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

    @Override
    public Cliente getClientById(Integer id) {
        if (clientes != null) {
            for (Cliente c : clientes) {
                if (c.getId().equals(id)) return c;
            }

            return null;
        } else return null;
    }

    @Override
    public Cliente addClient(Cliente cliente) throws Exception {
        if (cliente.validar()) {
            cliente.setId(clientes.size() + 1);
            clientes.add(cliente);
            return cliente;
        } else throw new InvalidObjectException("Cliente inválido");
    }

    @Override
    public boolean deleteClient(Cliente cliente) throws Exception {
        if (cliente.getId() > 0) {
            for (Cliente c : clientes) {
                if (c.getId().equals(cliente.getId())) clientes.remove(c);
                return true;
            }
            throw new NoSuchElementException("Cliente no encontrado");
        } else throw new Exception("Cliente inválido");
    }

    @Override
    public Cliente updateClient(Cliente cliente) throws Exception {
        if (cliente.validar()) {
            for (Cliente c : clientes) {
                if (c.getId().equals(cliente.getId())) {
                    c = cliente;
                    return cliente;
                }
            }
            throw new NoSuchElementException("Cliente no encontrado");
        } else throw new InvalidObjectException("Cliente inválido");
    }
}
