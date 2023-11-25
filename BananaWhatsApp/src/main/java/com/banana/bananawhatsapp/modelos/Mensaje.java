package com.banana.bananawhatsapp.modelos;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mensaje")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "from_user")
    private Usuario from;

    @OneToOne
    @JoinColumn(name = "to_user")
    private Usuario to;

    private String cuerpo;
    private LocalDate fecha;

    private boolean validarFecha() {
        return this.fecha != null && this.fecha.compareTo(LocalDate.now()) <= 0;
    }

    public boolean valido() throws MensajeException {
        if (from != null && to != null && from.getId() > 0 && to.getId() > 0 && cuerpo != null && cuerpo.length() > 10 && validarFecha())
            return true;
        else throw new MensajeException("Mensaje no valido");
    }


}
