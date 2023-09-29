package es.netmind.simuladorcoches.modelos.coches;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SUV extends Coche implements ICoche{

    private int nCambios = 2;

    public SUV(String marca, String tipoCoche, int velocidad, int nCambios) {
        super(marca, tipoCoche, velocidad);
        this.nCambios = nCambios;
    }


    @Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            motor.acelerar();

            double inc = (this.nCambios > 1) ? 0.5 : 1;

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
