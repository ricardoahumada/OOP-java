package es.netmind.maquinacafe.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Empleado {
    private String nombre;
    private int ID;
    private String email;
    private String puesto;
    public boolean validar() {
        boolean valido = false;

        if (nombre == null) return valido;
        else if (nombre.length() < 4) return valido;
        else if (email == null) return valido;
        else if (email.indexOf("@") < 0) return valido;
        else valido = true;

        return valido;
    }
}
