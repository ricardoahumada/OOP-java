package com.bbva.maquinacafe.modelos;

public class Empleado {
    private String nombre;
    private int id;
    private String email;
    private String puesto;

    private String dni;

    public String getDni() {
        return dni;
    }

    private boolean validarDniContraServicioInternet() {
        // Conexión a servicio internet
        return true;
    }

    public void setDni(String dni) {
        boolean isOkInternet = validarDniContraServicioInternet();
        if (dni != null && dni.length() == 9 && isOkInternet) {
            this.dni = dni;
        }
    }

    public Empleado(String nombre, int id, String email, String puesto) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.puesto = puesto;
    }

    public boolean validar() {
        if (nombre != null && email != null && puesto != null) return true;
        else return false;
    }

    // setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // System.out.println(nombre.charAt(0));
        if (nombre != null && nombre.length() > 2 && !nombre.equals("") && nombre.length() < 30) this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "com.bbva.maquinacafe.modelos.Empleado{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", puesto='" + puesto + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
