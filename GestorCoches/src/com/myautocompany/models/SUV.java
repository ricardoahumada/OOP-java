package com.myautocompany.models;

public class SUV extends Coche implements ICoche {

    private int nCambios = 2;

    public SUV(String marca, String tipoCoche, int velocidad, int nCambios) {
        super(marca, tipoCoche, velocidad);
        this.nCambios = nCambios;
    }


    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            double inc = (this.nCambios > 1) ? 0.5 : 1;

            double tiempo = (double) distancia / ((double) this.velocidad * inc);
            this.posicion += distancia;
            return tiempo;
        } else {
            return 0;
        }
    }

    @Override
    public double acelerar() {
        return 0;
    }

    public void parar() {
        this.arrancado = false;
    }

    public void  arrancar() {
        this.arrancado = true;
    }

    @Override
    public void ralenti() {
        System.out.println("a ralenti");
    }
}
