package es.netmind.maquinacafe.modelos.tazacafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@AllArgsConstructor
public class TazaCafe {
    private int id;
    protected double volumen;
    private String fabricante;
    private boolean lista;

    public boolean prepararTaza() {
        System.out.println("Preparando taza café-...");
        return true;
    }

    public boolean servirTaza() {
        System.out.println("Taza lista-...");
        this.lista = true;
        return this.lista;
    }


}