package com.banana.modelos;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class User {
    private String nombre;
    private String email;

    // @Inject
    @Autowired
    private IMessage mensaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IMessage getMensaje() {
        return mensaje;
    }

    public void setMensaje(IMessage mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", mensaje=" + mensaje +
                '}';
    }
}
