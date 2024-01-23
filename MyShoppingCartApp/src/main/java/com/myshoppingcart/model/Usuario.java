package com.myshoppingcart.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String nombre;
    private String apellido;
    private String email;
    private int interes;
    private double saldo;
    private String password;
    private LocalDate nacimiento;
    private boolean activo;

    @OneToOne(mappedBy = "usuario")
    private Direccion direccion;

    @OneToMany(mappedBy = "usuario")
    List<Compra> compras;

    public Usuario(Integer uid) {
        this.uid = uid;
    }

    public Usuario(Integer uid, String nombre, String apellido, String email, int interes, double saldo, String password, LocalDate nacimiento, boolean activo, Direccion direccion) {
        this.uid = uid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.interes = interes;
        this.saldo = saldo;
        this.password = password;
        this.nacimiento = nacimiento;
        this.activo = activo;
        this.direccion = direccion;
    }
}
