package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;

import java.util.List;

public interface IProductoRepository {
    public List<Producto> getProducts() throws Exception;
    public List<Producto> getUserProducts(int uid) throws Exception;

}
