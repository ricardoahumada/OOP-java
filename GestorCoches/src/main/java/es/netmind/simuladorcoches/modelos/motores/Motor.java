package es.netmind.simuladorcoches.modelos.motores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter @ToString
public abstract class Motor {
    private Integer id;
    private Integer potencia;

    public  abstract void arrancar();
    public  abstract void acelerar();
    public  abstract void parar();

}
