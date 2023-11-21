package com.coches.gestor.modelos.coches;

import com.coches.gestor.exceptions.MotorException;
import com.coches.gestor.modelos.motores.Motor;

public interface ICoche {
    public void acelerar(int aceleracion);

    boolean arrancar() throws MotorException;

    double avanzar(int distancia);

    boolean parar();

    void setMotor(Motor motor);
}
