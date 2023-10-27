package com.mymotorcompany.simuladorcoches.modelos.motores;

public abstract class Motor {
    private Integer id;
    private Integer potencia;

    public Motor(Integer id, Integer potencia) {
        this.potencia = potencia;
    }

    public  abstract void arrancar();
    public  abstract void acelerar();
    public  abstract void parar();

}
