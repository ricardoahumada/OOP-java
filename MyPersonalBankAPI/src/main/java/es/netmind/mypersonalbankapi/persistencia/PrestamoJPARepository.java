package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoJPARepository extends JpaRepository<Prestamo, Long> {
}
