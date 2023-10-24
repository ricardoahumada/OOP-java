package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CompraDBRepository implements ICompraRepository {
    private static Logger logger = Logger.getLogger("CompraDBRepository");
    private final static String connUrl = "jdbc:mysql://localhost/productos_db?user=productos_user&password=prod123";

    @Override
    public Compra insertCompra(Compra nuevaCompra) throws Exception {
        boolean exito = false;

        Connection conn = DriverManager.getConnection(connUrl);

        try {
            conn.setAutoCommit(false);

            // OBTENEMOS EL PRODUCTO
            String sql = "SELECT * FROM producto WHERE pid = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, nuevaCompra.getProducto());
            ResultSet rs = pstm.executeQuery();
            double precio = 0;
            if (rs.next()) {
                precio = rs.getDouble("precio");
            } else {
                throw new ProductNotFoundException();
            }

            // INSERTAR EN COMPRA
            sql = "INSERT INTO compra VALUES(NULL,?,?,?,?)";
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, nuevaCompra.getUsuario());
            pstm.setInt(2, nuevaCompra.getProducto());
            pstm.setInt(3, nuevaCompra.getCantidad());

            pstm.setString(4, nuevaCompra.getFecha().toString());
            int rows = pstm.executeUpdate();

            ResultSet generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                nuevaCompra.setCid(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating compra failed, no ID obtained.");
            }
            pstm.close();

            logger.info("Nueva compra:" + nuevaCompra);

            // ACTUALIZAR SALDO DE USUARIO
            sql = "UPDATE usuario u SET u.saldo = u.saldo - ? WHERE u.uid=?";
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, nuevaCompra.getCantidad());
            pstm.setInt(2, nuevaCompra.getUsuario());
            rows = pstm.executeUpdate();

            pstm.close();

            // ACTUALIZAR EXISTENCIAS DE MAQUILLAJE
            sql = "UPDATE producto p SET p.existencias=p.existencias - ? WHERE p.pid=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, nuevaCompra.getCantidad());
            pstm.setInt(2, nuevaCompra.getProducto());
            rows = pstm.executeUpdate();

            pstm.close();

            conn.commit();

            conn.close();

            logger.info("Transacción exitosa");
            exito = rows > 0 ? true : false;

        } catch (Exception e) {
            conn.rollback();
            logger.severe("Transacción fallida:" + e.getMessage());
            e.printStackTrace();
            exito = false;
        }

        return nuevaCompra;
    }
}
