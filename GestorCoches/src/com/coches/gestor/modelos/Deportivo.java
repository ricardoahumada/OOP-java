package com.coches.gestor.modelos;

public class Deportivo extends Coche {

    private boolean turbo;

    public Deportivo(String marca, String tipoCoche, int velocidad, boolean turbo) {
        super(marca, tipoCoche, velocidad);
        this.turbo = turbo;
    }


    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            int inc = this.turbo ? 2 : 1;

            double tiempo = (double) distancia / ((double) this.velocidad * inc);
            this.posicion += distancia;
            return tiempo;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public String toString() {
        return "Deportivo{" +
                "turbo=" + turbo +
                "} " + super.toString();
    }
}
