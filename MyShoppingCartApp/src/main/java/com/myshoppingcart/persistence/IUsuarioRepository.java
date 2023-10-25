package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;

import java.sql.SQLException;

public interface IUsuarioRepository {
    public boolean existeUsuario(String email, String pass) throws Exception;

    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception;

    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception;

    public Usuario updateUsuario(Usuario unUsuario) throws UsuarioNotFoundException;

    public boolean deleteUsuario(Integer uid) throws UsuarioNotFoundException;

}
