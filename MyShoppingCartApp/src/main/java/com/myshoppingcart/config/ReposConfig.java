package com.myshoppingcart.config;

import com.myshoppingcart.persistence.*;
import com.myshoppingcart.properties.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ReposConfig {

    @Bean
    public String getUrlConn() throws IOException {
        PropertyValues props = new PropertyValues();
        String connUrl = props.getPropValues().getProperty("db_url");
        return connUrl;
    }

    @Autowired
    String connUrl;

    @Bean
    public DBConnector createDBConnector() {
        return new DBConnector();
    }

    @Bean
    public ICompraRepository createICompraRepository() {
         CompraDBRepository repo = new CompraDBRepository();
         repo.setConnUrl(connUrl);
         return repo;
    }

    @Bean
    public IProductoRepository createIProductoRepository() {
         ProductoDBRepository repo = new ProductoDBRepository();
         repo.setConnUrl(connUrl);
         return repo;
    }

    @Bean
    public IUsuarioRepository createIUsuarioRepository() {
         UsuarioDBRepository repo = new UsuarioDBRepository();
         repo.setDb_url(connUrl);
         return repo;
    }

}
