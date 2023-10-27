package com.myautocompany.gestorcoches.modelos;

public interface ICoche {
    public double avanzar(int distancia);
    public boolean arrancar();
    public boolean parar();

    public boolean validar();
}
