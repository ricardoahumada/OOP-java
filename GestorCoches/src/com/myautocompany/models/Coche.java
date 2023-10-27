package com.myautocompany.models;

public abstract class Coche {
    public static int puertas = 5;
    private String marca;
    private String tipoCoche;
    protected int velocidad;
    protected int posicion = 0;
    protected boolean arrancado = false;

    public Coche(String marca, String tipoCoche, int velocidad) {
        this.marca = marca;
        this.tipoCoche = tipoCoche;
        this.velocidad = velocidad;
    }

    /*public double avanzar(int distancia) {
        if (this.arrancado) {
            double tiempo = (double) distancia / (double) this.velocidad;
            this.posicion += distancia;
            return tiempo;
        } else {
            return 0;
        }
    }*/

    public abstract void ralenti();

    @Override
    public String toString() {
        return "Coche{" +
                "puertas=" + puertas +
                ", marca='" + marca + '\'' +
                ", tipoCoche='" + tipoCoche + '\'' +
                ", velocidad=" + velocidad +
                ", posicion=" + posicion +
                ", arrancado=" + arrancado +
                '}';
    }
}
