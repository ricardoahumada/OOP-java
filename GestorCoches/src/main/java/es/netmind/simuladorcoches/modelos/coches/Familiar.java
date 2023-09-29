package es.netmind.simuladorcoches.modelos.coches;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Familiar extends Coche implements ICoche {

    private int nAsientos = 5;

    public Familiar(String marca, String tipoCoche, int velocidad, int nAsientos) {
        super(marca, tipoCoche, velocidad);
        this.nAsientos = nAsientos;
    }

    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            motor.acelerar();

            double inc = 1;
            if (nAsientos > 5) inc = 0.5;
            else if (nAsientos < 5) inc = 1.5;
            else inc = 1;

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
    public void ralenti() {

    }
}
