package com.myshoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Producto {
    private Integer pid;
    private String codigo;
    private String marca;
    private String tipo;
    private double precio;
    private int existencias;

    public Producto(Integer mid) {
        this.pid = mid;
    }

    public Producto(Integer id, String cod, double prec) {
        this.pid = id;
        this.codigo = cod;
        this.precio = prec;
    }

}
