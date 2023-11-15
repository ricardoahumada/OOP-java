package com.banana.modelos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class User {
    private String nombre;
    private String email;

    @Autowired
    @Qualifier("aMessage")
    private IMessage mensaje;

}
