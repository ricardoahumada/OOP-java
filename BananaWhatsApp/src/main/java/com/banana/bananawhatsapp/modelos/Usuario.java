package com.banana.bananawhatsapp.modelos;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String email;
    private LocalDate alta;
    private boolean activo;

    private boolean validarNombre() {
        return this.nombre != null && this.nombre.length() >= 3;
    }

    private boolean validarEmail() {
        return this.email != null && this.email.indexOf("@") > 0 && this.email.indexOf(".") > 0;
    }

    private boolean validarAlta() {
        return this.alta != null && this.alta.compareTo(LocalDate.now()) <= 0;
    }

    public boolean valido() throws UsuarioException {
        if (activo &&
                validarNombre() &&
                validarEmail() &&
                validarAlta()) return true;
        else throw new UsuarioException("Usuario no valido");
    }
}
