package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaJPARepository extends JpaRepository<Empresa, Long> {
}
