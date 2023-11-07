package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import es.netmind.mypersonalbankapi.modelos.cuentas.Ahorro;
import es.netmind.mypersonalbankapi.modelos.cuentas.Corriente;
import es.netmind.mypersonalbankapi.modelos.cuentas.Cuenta;
import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;


/*
@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.microcompany.productsservice.persistence"})
@AutoConfigureTestEntityManager
*/
@SpringBootTest
public class ClientesJPARepositoryTest {

    @Autowired
    private ClienteJPARepository clienteRepo;

    @Autowired
    private PrestamoJPARepository prestamoRepo;

    @Autowired
    private CuentaJPARepository cuentaRepo;


    @Test
    void insert() throws Exception {

        System.out.println("*****INSERT PRESTAMOS");
        List<Prestamo> prestamos = new ArrayList<>();
        prestamos.add(new Prestamo(1, LocalDate.now(), 1000.0, 1000.0, 4, 2, false, false, 2));
        prestamos.add(new Prestamo(2, LocalDate.now(), 100000.0, 100000.0, 4, 2, false, false, 25));

        for (Prestamo prestamo : prestamos) {
            prestamoRepo.save(prestamo);
        }


        System.out.println("*****INSERT Cuentas");

        List<Cuenta> cuentas = new ArrayList<>();

        cuentas.add(new Ahorro(1, LocalDate.now(), 100.0, 1.1, 0.2));
        cuentas.add(new Corriente(2, LocalDate.now(), 200.0, 0.5, 0.2));
        cuentas.add(new Ahorro(3, LocalDate.now(), 300.0, 1.1, 0.2));
        cuentas.add(new Ahorro(4, LocalDate.now(), 300.0, 1.1, 0.2));

        for (Cuenta cuenta : cuentas) {
            cuentaRepo.save(cuenta);
        }


        System.out.println("*****INSERT Clientes");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Personal(null, "Juan Juanez", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J"));
        clientes.get(0).asociarPrestamo(prestamos.get(0));

        clientes.add(new Personal(null, "Luisa Perez", "lp@l.com", "Calle LP 2", LocalDate.now(), true, false, "12345678L"));

        clientes.add(new Empresa(null, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"}));
        clientes.get(2).asociarPrestamo(prestamos.get(1));

        clientes.get(0).asociarCuenta(cuentas.get(0));
        clientes.get(0).asociarCuenta(cuentas.get(3));
        clientes.get(1).asociarCuenta(cuentas.get(2));
        clientes.get(2).asociarCuenta(cuentas.get(1));

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            clienteRepo.save(cliente);
        }

    }


}
