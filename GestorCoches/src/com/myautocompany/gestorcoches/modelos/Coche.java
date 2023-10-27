package com.myautocompany.gestorcoches.modelos;

public abstract class Coche {

    public static int puertas = 5;
    protected String marca;
    protected String tipoCoche;
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

    /*public double avanzar(int distancia) {
        if (this.arrancado) {
            double tiempo = (double) distancia / (double) this.velocidad;
            this.posicion += distancia;
            return tiempo;
        } else return 0;

    }*/

    public boolean parar() {
        this.arrancado = false;
        return true;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", tipoCoche='" + tipoCoche + '\'' +
                ", velocidad=" + velocidad +
                ", posicion=" + posicion +
                ", arrancado=" + arrancado +
                ", puertas=" + puertas +
                '}';
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean validar() {
        if (!this.getMarca().equals("Porsche")) return  false;
        else return true;
    }

    // abstract void ralenti();
}