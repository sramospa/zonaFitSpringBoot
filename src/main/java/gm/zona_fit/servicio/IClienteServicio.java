package gm.zona_fit.servicio;

import gm.zona_fit.model.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId(Integer idCliente);

    public void guardarCliente(Cliente cliente);//el mismo metodo para insertar o para actualizar
    //si el id es null insertara y si tiene valores realiza un update

    public void elimiarCliente(Cliente cliente);
}
