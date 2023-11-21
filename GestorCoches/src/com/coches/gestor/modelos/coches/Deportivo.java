package com.coches.gestor.modelos.coches;

public class Deportivo extends Coche implements ICoche {

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

    public void acelerarTurbo(){
        //....
    }

    @Override
    public void frenarLentamente() {

    }

    @Override
    public String toString() {
        return "Deportivo{" +
                "turbo=" + turbo +
                "} " + super.toString();
    }

    @Override
    public void acelerar(int aceleracion) {
        System.out.println("Deportivo acelenrando....");
    }
}
