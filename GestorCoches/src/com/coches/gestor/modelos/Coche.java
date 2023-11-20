package com.coches.gestor.modelos;


public class Coche {

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

    public boolean arrancar() {
        this.arrancado = true;
        return true;
    }

    public double avanzar(int distancia) {
        if (this.arrancado) {
            double tiempo = (double) distancia / (double) this.velocidad;
            this.posicion += distancia;
            return tiempo;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    public boolean parar() {
        this.arrancado = false;
        return true;
    }


    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", tipoCoche='" + tipoCoche + '\'' +
                ", velocidad=" + velocidad +
                ", posicion=" + posicion +
                ", arrancado=" + arrancado +
                '}';
    }


}