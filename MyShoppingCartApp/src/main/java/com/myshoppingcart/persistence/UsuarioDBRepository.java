package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import com.myshoppingcart.properties.PropertyValues;

import java.sql.*;

public class UsuarioDBRepository implements IUsuarioRepository {
    PropertyValues props = new PropertyValues();

    @Override
    public boolean existeUsuario(String email, String pass) throws Exception {
        boolean existe = false;

        String db_url = props.getPropValues().getProperty("db_url");
        Connection conn = DriverManager.getConnection(db_url);
        System.out.println("Conectado!");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM usuario u WHERE u.email='" + email + "' AND password='" + pass + "'");

        if (rs.next()) {
            System.out.println(rs);
            existe = true;
        }

        stmt.close();
        conn.close();

        return existe;
    }

    @Override
    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception {
        return null;
    }

    @Override
    public Usuario insertUsuario(Usuario nuevoUsuario) throws Exception {
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario unUsuario) throws UsuarioNotFoundException {
        return null;
    }

    @Override
    public boolean deleteUsuario(Integer uid) throws UsuarioNotFoundException {
        return false;
    }
}
