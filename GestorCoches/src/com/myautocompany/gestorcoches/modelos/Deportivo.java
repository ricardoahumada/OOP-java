package com.myautocompany.gestorcoches.modelos;

public class Deportivo extends Coche implements ICoche, IMovible {
    private boolean turbo;

    public Deportivo(String marca, String tipoCoche, int velocidad, boolean turbo) {
        super(marca, tipoCoche, velocidad);
        this.turbo = turbo;
    }

    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            /*
            int inc = 0;
            if (this.turbo) inc = 2;
            else inc = 1;
            */
            int inc = this.turbo ? 2 : 1;

            double tiempo = (double) distancia / ((double) this.velocidad * inc);
            this.posicion += distancia;
            return tiempo;
        } else {
            return 0;
        }
    }

    @Override
    public boolean acelarar(int inc) {
        return true;
    }

}
