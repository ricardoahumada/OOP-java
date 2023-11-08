package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Producto;
import com.myshoppingcart.properties.PropertyValues;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDBRepository implements IProductoRepository {
    private static String connUrl;

    public ProductoDBRepository() throws IOException {
        PropertyValues props = new PropertyValues();
        connUrl = props.getPropValues().getProperty("db_url");
    }

    @Override
    public List<Producto> getProducts() throws Exception {
        List<Producto> listADevolver = new ArrayList<>();
        String sql = "SELECT p.* FROM producto p WHERE 1";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                // ordenes sql
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
        ) {
            while (rs.next()) {
                listADevolver.add(new Producto(rs.getInt("mid"), rs.getString("codigo"), rs.getString("marca"),
                        rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias")));
            }
        }

        return listADevolver;
    }

    @Override
    public List<Producto> getUserProducts(int uid) throws Exception {
        List<Producto> listADevolver = new ArrayList<>();
        String sql = "SELECT p.* FROM producto p INNER JOIN compra c ON c.producto=p.pid WHERE c.usuario=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listADevolver.add(new Producto(
                        rs.getInt("pid"),
                        rs.getString("codigo"),
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getInt("precio"),
                        rs.getInt("existencias")
                ));
            }
        }

        return listADevolver;
    }

    @Override
    public Producto insertarProducto(Producto prod) throws Exception {
        return null;
    }


}

