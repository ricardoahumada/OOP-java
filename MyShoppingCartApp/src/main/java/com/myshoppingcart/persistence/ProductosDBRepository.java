package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductosDBRepository implements IProductosRepository{
    private static Logger logger = Logger.getLogger("ProductosDBRepository");
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

            logger.info("Conexión exitosa");

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
                    rs.getString("coquetitud"),
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
    public List<Producto> getUserProducts(int uid) throws Exception {
        List<Producto> listADevolver = new ArrayList<Producto>();
        Connection conn = DriverManager.getConnection(connUrl);

        // ordenes sql
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT m.* FROM producto m INNER JOIN compra c ON c.cosmetico=m.mid WHERE c.usuario=" + uid);

        while (rs.next()) {
            listADevolver.add(new Producto(
                    rs.getInt("mid"),
                    rs.getString("codigo"),
                    rs.getString("marca"),
                    rs.getString("tipo"),
                    rs.getInt("precio"),
                    rs.getInt("existencias")
            ));
        }

        stmt.close();
        conn.close();

        return listADevolver;
    }

}
