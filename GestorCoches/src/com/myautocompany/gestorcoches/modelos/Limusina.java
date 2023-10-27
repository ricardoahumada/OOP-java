package com.myautocompany.gestorcoches.modelos;

public class Limusina extends Coche implements ICoche{

    private int ejes;

    public Limusina(String marca, String tipoCoche, int velocidad, int ejes) {
        super(marca, tipoCoche, velocidad);
        this.ejes = ejes;
    }


    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {

            double tiempo = (double) distancia / ((double) this.velocidad * 1/ejes);
            this.posicion += distancia;
            return tiempo;
        } else {
            return 0;
        }
    }

    public void metodoConcreto(){
        //impli
    }
}
