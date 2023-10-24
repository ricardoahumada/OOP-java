package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;

import java.util.List;

public interface IUsuarioRepository {
    public boolean existeUsuario(String email, String pass);

    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception;

    public Usuario insertUsuaio(Usuario nuevoUsuario) throws Exception;

    public Usuario updateUsuaio(Usuario unUsuario) throws UsuarioNotFoundException;

    public boolean deleteUsuaio(Integer uid) throws UsuarioNotFoundException;

}
