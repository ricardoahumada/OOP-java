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

//    @OneToOne
//    @JoinColumn(name = "direccion_id")
    @OneToOne(mappedBy = "usuario")
    private Direccion direccion;

    public Usuario(Integer uid) {
        this.uid = uid;
    }


}
