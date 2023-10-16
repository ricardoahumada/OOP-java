package es.netmind.simuladorcoches.modelos.coches;

import es.netmind.simuladorcoches.excepciones.CocheException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CocheTest {

    @ParameterizedTest
    @CsvSource({"renault,familiar,120", "nissan,4x4,1"})
    void dado_valoreValidosCondicionantes_cuandoValidar_entoncesTrue(String marca, String tipo, int velocidad) throws CocheException {
        // dado
        Coche coche = new Familiar(marca, tipo, velocidad, 5);

        //cuando
        boolean esValido = coche.validar();

        //entonces
        assertTrue(esValido);
    }

    @ParameterizedTest
    @CsvSource({"ren,familiar,120", "renault,fa,120","renault,familiar,0"})
    void dado_valoreInvalidosCondicionantes_cuandoValidar_entoncesExcepcion(String marca, String tipo, int velocidad) throws CocheException {
        // dado
        Coche coche = new Familiar(marca, tipo, velocidad, 5);

        //entonces
        assertThrows(CocheException.class, () -> {
            //cuando
            boolean esValido = coche.validar();

        });
    }

}