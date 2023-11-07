package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
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


    @Test
    void insert() throws Exception {

        System.out.println("*****INSERT PRESTAMOS");
        List<Prestamo> prestamos = new ArrayList<>();
        prestamos.add(new Prestamo(1, LocalDate.now(), 1000.0, 1000.0, 4, 2, false, false, 2));
        prestamos.add(new Prestamo(2, LocalDate.now(), 100000.0, 100000.0, 4, 2, false, false, 25));

        prestamoRepo.save(prestamos.get(0));
        prestamoRepo.save(prestamos.get(1));

        System.out.println("*****INSERT Clientes");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Personal(1, "Juan Juanez", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J"));
        clientes.get(0).asociarPrestamo(prestamos.get(0));

        clientes.add(new Personal(2, "Luisa Perez", "lp@l.com", "Calle LP 2", LocalDate.now(), true, false, "12345678L"));

        clientes.add(new Empresa(3, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"}));
        clientes.get(2).asociarPrestamo(prestamos.get(1));

        clienteRepo.save(clientes.get(0));
        clienteRepo.save(clientes.get(1));
        clienteRepo.save(clientes.get(2));

    }


}
