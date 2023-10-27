package com.myautocompany.simuladorcoches.modelos.coches;


import com.myautocompany.simuladorcoches.excepciones.CocheException;
import com.myautocompany.simuladorcoches.modelos.motores.Motor;

public interface ICoche {
    public double avanzar(int distancia);
    public boolean acelarar(int kph);
    public boolean arrancar();
    public boolean parar();
    public boolean validar() throws CocheException;
    public void setMotor(Motor motor);

}
