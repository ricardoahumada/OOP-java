package com.mymotorcompany.simuladorcoches.modelos.coches;


import com.mymotorcompany.simuladorcoches.excepciones.CocheException;
import com.mymotorcompany.simuladorcoches.modelos.motores.Motor;

public interface ICoche {
    public double avanzar(int distancia);
    public boolean acelarar(int kph);
    public boolean arrancar();
    public boolean parar();
    public boolean validar() throws CocheException;
    public void setMotor(Motor motor);

}
