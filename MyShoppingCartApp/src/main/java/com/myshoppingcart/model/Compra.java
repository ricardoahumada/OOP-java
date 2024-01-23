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
public class Compra {
    private Integer cid;
    private Usuario usuario;
    private List<Producto> productos;
    private LocalDate fecha;
}
