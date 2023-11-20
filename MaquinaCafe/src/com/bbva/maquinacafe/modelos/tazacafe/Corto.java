package com.bbva.maquinacafe.modelos.tazacafe;

public class Corto  extends TazaCafe{
    int cantidad_leche;

    public Corto(int id, double volumen, String fabricante, boolean lista, int cantidad_leche) {
        super(id, volumen, fabricante, lista);
        this.cantidad_leche = cantidad_leche;
        this.tieneAsa = false;
    }

    @Override
    public boolean prepararTaza() {
        // proceso diferente propio de corto
        System.out.println("Preparando taza café con cantidad leche = " + this.cantidad_leche + " ...");
        return true;
    }

    @Override
    public String toString() {
        return "Corto{" +
                "cantidad_leche=" + cantidad_leche +
                "} " + super.toString();
    }
}
