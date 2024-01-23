package com.myshoppingcart.service;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import com.myshoppingcart.persistence.ICompraRepository;
import com.myshoppingcart.persistence.IUsuarioRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


@Setter
@Service
public class ShoppingCart implements IShoppingCart {

    private ArrayList<Producto> items;

    //    @Autowired
    private ICompraRepository repoCompras;
    private IUsuarioRepository repoUsuarios;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    @Override
    public double getBalance() {
        double balance = 0.00;
        for (Iterator i = items.iterator(); i.hasNext(); ) {
            Producto item = (Producto) i.next();
            balance += item.getPrecio();
        }
        return balance;
    }

    @Override
    public void addItem(Producto item) {
        items.add(item);
    }

    @Override
    public void removeItem(Producto item)
            throws ProductNotFoundException {
        if (!items.remove(item)) {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void empty() {
        items.clear();
    }

    @Override
    public void comprar() {

        try {
            Usuario currentUser = repoUsuarios.getUsuario("juana@e.com", "juanason_1");
            Compra compra = new Compra(null, currentUser, items, LocalDate.now());
            repoCompras.insertCompra(compra);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}