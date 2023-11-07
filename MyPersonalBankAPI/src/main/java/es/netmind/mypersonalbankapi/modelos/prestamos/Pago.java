package es.netmind.mypersonalbankapi.modelos.prestamos;

import javax.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
