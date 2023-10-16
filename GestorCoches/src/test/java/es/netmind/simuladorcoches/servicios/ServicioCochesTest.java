package es.netmind.simuladorcoches.servicios;

import es.netmind.simuladorcoches.modelos.coches.Deportivo;
import es.netmind.simuladorcoches.modelos.coches.ICoche;
import es.netmind.simuladorcoches.persistencia.CochesRepositorio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCochesTest {

    @Test
    void dadoListaCochesValidos_cuando_encontrarMasRapido_entonces_encuentra_elMasRapido() throws Exception {
        //dado
        List<ICoche> cochesPrueba = CochesRepositorio.getAll();

        //cuando
        ICoche masRapido = ServicioCoches.encontrarMasRapido(cochesPrueba, 200);

        // entonces
        assertNotNull(masRapido);
        assertTrue(masRapido.validar());
        assertEquals(cochesPrueba.get(1), masRapido);
    }

    @Test
    void dadoListaCochesAlMenosUnoNoValido_cuando_encontrarMasRapido_entonces_Excepcion() throws Exception {
        //dado
        List<ICoche> cochesPrueba = CochesRepositorio.getAll();
        cochesPrueba.add(new Deportivo("", "", 150, false));

        // entonces
        assertThrows(Exception.class, () -> {
            //cuando
            ICoche masRapido = ServicioCoches.encontrarMasRapido(cochesPrueba, 200);
        });

    }


}