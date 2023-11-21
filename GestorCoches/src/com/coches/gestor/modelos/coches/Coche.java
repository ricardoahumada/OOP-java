package com.coches.gestor.modelos.coches;


import com.coches.gestor.exceptions.MotorException;
import com.coches.gestor.modelos.motores.Motor;

public class Coche {

    private String marca;
    private String tipoCoche;
    protected int velocidad;
    protected int posicion = 0;
    protected boolean arrancado = false;

    protected Motor motor;

    public static int ruedas = 4;

    public Coche(String marca, String tipoCoche, int velocidad) {
        this.marca = marca;
        this.tipoCoche = tipoCoche;
        this.velocidad = velocidad;
    }

    public boolean arrancar() throws MotorException {
        if (motor != null) {
            this.motor.arrancar();
            this.arrancado = true;
            return true;
        } else {
//            return false;
            throw new MotorException("No tiene Motor!!");
        }
    }

    /*@Override
    public double avanzar(int distancia) {
        if (this.arrancado) {
            Double mueve = this.motor.mover();
            double tiempo = mueve * (double) distancia / (double) this.velocidad;
            this.posicion += distancia;
            return tiempo;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }*/

    public boolean parar() {
        if (this.motor != null) this.motor.arrancar();
        this.arrancado = false;
        return true;
    }

    public static void frenar(){
        // cuerpo de frenar
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", tipoCoche='" + tipoCoche + '\'' +
                ", velocidad=" + velocidad +
                ", posicion=" + posicion +
                ", arrancado=" + arrancado +
                '}';
    }


}