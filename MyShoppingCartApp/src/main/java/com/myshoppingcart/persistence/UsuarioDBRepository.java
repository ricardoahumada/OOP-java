package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class UsuarioDBRepository implements IUsuarioRepository {
    private static Logger logger = Logger.getLogger("UsuarioDBRepository");
    private final static String connUrl = "jdbc:mysql://localhost/productos_db?user=productos_user&password=prod123";

    @Override
    public boolean existeUsuario(String email, String pass) {

        try {
            Connection conn = DriverManager.getConnection(connUrl);

            // ordenes sql
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT u.* FROM usuario u WHERE u.email='" + email + "' AND password='" + pass + "' LIMIT 1");

            boolean existeUsuario = false;
            if (rs.next()) {
                existeUsuario = true;
            }

            stmt.close();
            conn.close();

            return existeUsuario;
        } catch (Exception e) {
            logger.severe("Error en la conexión de BBDD:" + e);
            return false;
        }

    }

    @Override
    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception {
        Usuario usuarioADevolver = null;

        Connection conn = DriverManager.getConnection(connUrl);

        // ordenes sql
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT u.* FROM usuario u WHERE u.email='" + email + "' AND password='" + pass + "' LIMIT 1");

        if (rs.next()) {
            usuarioADevolver = new Usuario(
                    rs.getInt("uid"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getInt("interes"),
                    rs.getDouble("saldo"),
                    "",
                    rs.getDate("nacimiento").toLocalDate(),
                    rs.getBoolean("activo")
            );
        } else {
            throw new UsuarioNotFoundException();
        }

        stmt.close();

        conn.close();

        return usuarioADevolver;
    }

    @Override
    public Usuario insertUsuaio(Usuario nuevoUsuario) throws Exception {
        return null;
    }

    @Override
    public Usuario updateUsuaio(Usuario nuevoUsuario) throws UsuarioNotFoundException {
        return null;
    }

    @Override
    public boolean deleteUsuaio(Integer uid) throws UsuarioNotFoundException {
        return false;
    }

}
