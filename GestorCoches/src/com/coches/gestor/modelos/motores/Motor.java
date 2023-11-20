package com.coches.gestor.modelos.motores;

public class Motor {
    private Integer consumo;
    private Integer potencia;
    private Integer cilindros;
    private Boolean encendido = false;

    public Motor(Integer consumo, Integer potencia, Integer cilindros) {
        this.consumo = consumo;
        this.potencia = potencia;
        this.cilindros = cilindros;
    }

    public boolean arrancar() {
        this.encendido = true;
        return true;
    }

    public Double mover() {
        if (this.encendido) {
            // calculos basados en consumo, potencia y cillindros
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public boolean parar() {
        this.encendido = false;
        return true;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "consumo=" + consumo +
                ", potencia=" + potencia +
                ", cilindros=" + cilindros +
                ", encendido=" + encendido +
                '}';
    }
}