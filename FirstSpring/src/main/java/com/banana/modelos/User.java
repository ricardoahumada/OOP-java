package com.banana.modelos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private String nombre;
    private String email;
    private IMessage mensaje;

}
