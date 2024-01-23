package com.myshoppingcart.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Direccion {
    private Long did;
    private String direccionCompleta;

}
