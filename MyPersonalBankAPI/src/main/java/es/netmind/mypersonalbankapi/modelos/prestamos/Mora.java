package es.netmind.mypersonalbankapi.modelos.prestamos;

import javax.persistence.*;

@Entity
@Table(name = "mora")
public class Mora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
