package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalJPARepository extends JpaRepository<Personal, Long> {
}
