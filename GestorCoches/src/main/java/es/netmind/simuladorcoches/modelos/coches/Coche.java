package es.netmind.simuladorcoches.modelos.coches;

import es.netmind.simuladorcoches.excepciones.CocheException;
import es.netmind.simuladorcoches.modelos.motores.Motor;
import lombok.*;

@Getter @Setter @ToString
@RequiredArgsConstructor
public abstract class Coche {

    public static int nRuedas = 4;
    @NonNull
    private String marca;
    @NonNull
    private String tipoCoche;
    @NonNull
    protected int velocidad;
    protected int posicion = 0;
    protected boolean arrancado = false;
    protected Motor motor;

    public boolean arrancar() {
        motor.arrancar();
        this.arrancado = true;
        return true;
    }

    /*public double avanzar(int distancia) {
        if (this.arrancado) {
            double tiempo = (double) distancia / (double) this.velocidad;
            this.posicion += distancia;
            return tiempo;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }*/

    public boolean parar() {
        motor.parar();
        this.arrancado = false;
        return true;
    }
    public abstract void ralenti();
    public boolean validar() throws CocheException {
        if (marca != null && tipoCoche != null && velocidad > 0 && marca.length() > 3 && tipoCoche.length() > 2) {
            return true;
        } else {
            throw new CocheException("Coche no valido:"+ this.marca);
        }
    }
}