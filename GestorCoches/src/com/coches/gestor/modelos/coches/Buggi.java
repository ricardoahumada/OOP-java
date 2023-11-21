package com.coches.gestor.modelos.coches;

public class Buggi extends Coche implements ICoche {

    private boolean arena;

    public Buggi(String marca, String tipoCoche, int velocidad, boolean arena) {
        super(marca, tipoCoche, velocidad);
        this.arena = arena;
    }

    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            int inc = this.arena ? 2 : 1;

            double tiempo = (double) distancia / ((double) this.velocidad * inc);
            this.posicion += distancia;
            return tiempo;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public void frenarLentamente() {

    }
    @Override
    public void acelerar(int aceleracion) {
        System.out.println("Buggi acelerando....");
    }
}
