package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;

import java.util.List;

public interface IClientesRepo {
    public List<Cliente> getAll();

    public Cliente getClientById(Integer id);

    public Cliente addClient(Cliente cliente) throws Exception;

    public boolean deleteClient(Cliente cliente) throws Exception;

    public Cliente updateClient(Cliente cliente) throws Exception;

}
