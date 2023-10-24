package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;

import java.util.List;

public interface IProductosRepository {
    public boolean existeUsuario(String email, String pass);

    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception;

    public List<Producto> getUserProducts(int uid) throws Exception;

}
