package com.myautocompany.models;

public class Deportivo extends Coche implements ICoche  {
    private boolean turbo;

    public Deportivo(String marca, String tipoCoche, int velocidad, boolean turbo) {
        super(marca, tipoCoche, velocidad);
        this.turbo = turbo;
    }

    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            /*if (this.turbo) inc = 2;
            else inc = 1;*/
            int inc = this.turbo ? 2 : 1;

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
