package es.netmind.simuladorcoches.modelos.coches;

import lombok.*;

@Getter @Setter @ToString
public class Deportivo extends Coche implements ICoche, IVolador {
    private boolean turbo;

    public Deportivo(String marca, String tipoCoche, int velocidad, boolean turbo) {
        super(marca, tipoCoche, velocidad);
        this.turbo = turbo;
    }


    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            motor.acelerar();
            int inc = this.turbo ? 2 : 1;

            double tiempo = (double) distancia / ((double) this.velocidad * inc);
            this.posicion += distancia;
            return tiempo;
        } else {
            return 0;
        }
    }

    @Override
    public boolean acelarar(int kph) {
        return false;
    }

    @Override
    public boolean volar() {
        return false;
    }

    @Override
    public void ralenti() {

    }
}
