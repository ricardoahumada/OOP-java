package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;


@ExtendWith(SpringExtension.class)
@DataJpaTest()
@ComponentScan(basePackages = {"com.microcompany.productsservice.persistence"})
@AutoConfigureTestEntityManager
public class ClientesJPARepositoryTest {

    @Autowired
    private PersonalJPARepository personalRepo;

    @Autowired
    private EmpresaJPARepository empresaRepo;

    @Autowired
    private PrestamoJPARepository prestamoRepo;

    @Test
    void insertPersonal() throws Exception {
        List<Prestamo> prestamos = new ArrayList<>();
        prestamos.add(new Prestamo(1, LocalDate.now(), 1000.0, 1000.0, 4, 2, false, false, 2));
        prestamos.add(new Prestamo(2, LocalDate.now(), 100000.0, 100000.0, 4, 2, false, false, 25));


        prestamoRepo.save(prestamos.get(0));
        prestamoRepo.save(prestamos.get(1));

        List<Prestamo> prestamos1 = prestamoRepo.findAll();
        System.out.println("\nprestamos1: " + prestamos1 + "\n");


        List<Personal> clientestoSave = new ArrayList<>();
        clientestoSave.add(new Personal(1, "Juan Juanez", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J"));
        clientestoSave.add(new Personal(2, "Luisa Perez", "lp@l.com", "Calle LP 2", LocalDate.now(), true, false, "12345678L"));

        personalRepo.save(clientestoSave.get(0));
        personalRepo.save(clientestoSave.get(1));

        List<Personal> clientes = personalRepo.findAll();
        System.out.println("\nclientes: " + clientes + "\n");

        assertThat(clientes).isNotNull();
    }

    @Test
    void insertEmpresa() throws Exception {
        List<Empresa> clientestoSave = new ArrayList<>();
        clientestoSave.add(new Empresa(3, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"}));

        empresaRepo.save(clientestoSave.get(0));

        List<Empresa> clientes = empresaRepo.findAll();

        System.out.println(clientes);

        assertThat(clientes).isNotNull();
    }


}
