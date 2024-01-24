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
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    /*
    // unidirecciona compra-usuario
    @ManyToOne()
    @JoinColumn(name = "user_id")*/
    //bidireccional compra - usuario
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @ManyToMany()
    @JoinTable(
            name = "compra_productos",
            joinColumns = {@JoinColumn(name = "compra_id")},
            inverseJoinColumns = {@JoinColumn(name = "producto_id")}
    )
    private List<Producto> productos;

    private LocalDate fecha;
}
