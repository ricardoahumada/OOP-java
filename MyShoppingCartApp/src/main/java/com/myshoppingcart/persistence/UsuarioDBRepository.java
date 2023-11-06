package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import com.myshoppingcart.properties.PropertyValues;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDBRepository implements IUsuarioRepository {
    private static String db_url = null;

    public UsuarioDBRepository() throws Exception {
        PropertyValues props = new PropertyValues();
        db_url = props.getPropValues().getProperty("db_url");
    }

    @Override
    public boolean existeUsuario(String email, String pass) throws Exception {
        boolean existe = false;

        String sql = "SELECT * FROM usuario u WHERE u.email=? AND password=?";

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, email);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println(rs);
                existe = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return existe;
    }

    @Override
    public Usuario getUsuario(String email, String pass) throws UsuarioNotFoundException, Exception {
        Usuario user = null;

        try (
                Connection conn = DriverManager.getConnection(db_url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuario u WHERE u.email='" + email + "' AND password='" + pass + "' LIMIT 1")
        ) {
            if (rs.next()) {
                user = new Usuario(
                        rs.getInt("uid"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getInt("interes"),
                        rs.getDouble("saldo"),
                        rs.getString("password"),
                        rs.getDate("nacimiento").toLocalDate(),
                        rs.getBoolean("activo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return user;
    }

    public List<Usuario> getUsuarios(String iniciales) throws Exception {

        List<Usuario> users = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(db_url);
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario u WHERE u.nombre LIKE ?");
        ) {

            stmt.setString(1, "%"+iniciales+"%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                users.add(
                        new Usuario(
                                rs.getInt("uid"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("email"),
                                rs.getInt("interes"),
                                rs.getDouble("saldo"),
                                rs.getString("password"),
                                rs.getDate("nacimiento").toLocalDate(),
                                rs.getBoolean("activo")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return users;
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
