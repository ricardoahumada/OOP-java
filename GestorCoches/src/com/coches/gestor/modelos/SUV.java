package com.coches.gestor.modelos;

public class SUV extends Coche{
    private int nCambios = 2;

    public SUV(String marca, String tipoCoche, int velocidad, int nCambios) {
        super(marca, tipoCoche, velocidad);
        this.nCambios = nCambios;
    }


    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {

//            double inc;
//            if (this.nCambios > 1) inc = 0.5;
//            else inc = 1;
            double inc = (this.nCambios > 1) ? 0.5 : 1;

            double tiempo = (double) distancia / ((double) this.velocidad * inc);
            this.posicion += distancia;
            return tiempo;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "SUV{" +
                "nCambios=" + nCambios +
                "} " + super.toString();
    }
}
